package fr.ferreira.donovan.exam.service;

import fr.ferreira.donovan.exam.DTO.RoundUpdateDTO;
import fr.ferreira.donovan.exam.entity.Round;
import fr.ferreira.donovan.exam.repository.RoundRepository;
import fr.ferreira.donovan.exam.DTO.RoundDTO;
import fr.ferreira.donovan.exam.exception.NotFoundExamException;
import fr.ferreira.donovan.exam.service.interfaces.DAOServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RoundService {

    private RoundRepository roundRepository;

    private CoordinateService coordinateService;

    private GameService gameService;

    public List<Round> findAll() {
        return this.roundRepository.findAll();
    }

    public Round getObjectById(Long id) {
        Optional<Round> optionalRound = roundRepository.findById(id);
        return optionalRound.orElseThrow(() -> new NotFoundExamException("Round", "id", id));
    }

    public Round create(RoundDTO roundDTO) {
        Round round = getObjectFromDTO(roundDTO);
        round.setOrigin(coordinateService.findRandom());
        round.setCreatedAt(LocalDateTime.now());
        return roundRepository.saveAndFlush(round);
    }

    public Round update(RoundUpdateDTO roundDTO, Long id) {
        Round round = new Round();
        if (id != null) {
            round = getObjectById(id);
        }
        round = getObjectFromDTO(roundDTO, round);
        Float longitudeSelected = Float.parseFloat(round.getSelected().getLongitude().replace(",","."));
        Float latitudeSelected = Float.parseFloat(round.getSelected().getLatitude().replace(",","."));
        Float longitudeOrigin = Float.parseFloat(round.getOrigin().getLongitude().replace(",","."));
        Float latitudeOrigin = Float.parseFloat(round.getOrigin().getLatitude().replace(",","."));
        double distance = 2 * 6371 * Math.asin(Math.sqrt(
                Math.pow(Math.sin((latitudeSelected - latitudeOrigin)/2),2) +
                Math.cos(latitudeSelected) * Math.cos(latitudeOrigin) *
                Math.pow(Math.sin((longitudeSelected - longitudeOrigin)/2),2)
        ));// sin⁻¹(√[sin²((θ₂ - θ₁)/2) + cosθ₁ × cosθ₂ × sin²((φ₂ - φ₁)/2)])
        round.setDistance(Math.round(distance));
        round.setPoints((int) (5000 - ((distance / 10000000)*5000)));
        return roundRepository.saveAndFlush(round);
    }

    public Round getObjectFromDTO(RoundDTO roundDTO) {
        return getObjectFromDTO(roundDTO, new Round());
    }

    public Round getObjectFromDTO(RoundDTO roundDTO, Round round) {
        round.setGame(gameService.getObjectById(roundDTO.getGameId()));
        return round;
    }

    public Round getObjectFromDTO(RoundUpdateDTO roundDTO, Round round) {
        round.setTime(roundDTO.getTime());
        round.setSelected(coordinateService.getObjectById(roundDTO.getSelectedCoordinateId()));
        return round;
    }
}
