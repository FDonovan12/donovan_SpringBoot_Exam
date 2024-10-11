package fr.ferreira.donovan.exam.service;

import fr.ferreira.donovan.exam.entity.Coordinate;
import fr.ferreira.donovan.exam.repository.CoordinateRepository;
import fr.ferreira.donovan.exam.DTO.CoordinateDTO;
import fr.ferreira.donovan.exam.exception.NotFoundExamException;
import fr.ferreira.donovan.exam.service.interfaces.DAOServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CoordinateService implements DAOServiceInterface<Coordinate, CoordinateDTO, Long> {

    private CoordinateRepository coordinateRepository;

    public List<Coordinate> findAll() {
        return this.coordinateRepository.findAll();
    }

    public Coordinate getObjectById(Long id) {
        Optional<Coordinate> optionalCoordinate = coordinateRepository.findById(id);
        return optionalCoordinate.orElseThrow(() -> new NotFoundExamException("Coordinate", "id", id));
    }

    public Coordinate create(CoordinateDTO coordinateDTO) {
        Coordinate coordinate = getObjectFromDTO(coordinateDTO);
        return coordinateRepository.saveAndFlush(coordinate);
    }

    public Coordinate findRandom() {
        return coordinateRepository.findRandom();
    }

    public Coordinate update(CoordinateDTO coordinateDTO, Long id) {
        Coordinate coordinate = new Coordinate();
        if (id != null) {
            coordinate = getObjectById(id);
        }
        coordinate = getObjectFromDTO(coordinateDTO);
        return coordinateRepository.saveAndFlush(coordinate);
    }

    public Coordinate getObjectFromDTO(CoordinateDTO coordinateDTO) {
        return getObjectFromDTO(coordinateDTO, new Coordinate());
    }

    public Coordinate getObjectFromDTO(CoordinateDTO coordinateDTO, Coordinate coordinate) {
        coordinate.setLongitude(coordinateDTO.getLongitude());
        coordinate.setLatitude(coordinateDTO.getLatitude());
        return coordinate;
    }
}
