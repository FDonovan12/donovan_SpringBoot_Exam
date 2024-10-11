package fr.ferreira.donovan.exam.service;

import fr.ferreira.donovan.exam.entity.Game;
import fr.ferreira.donovan.exam.entity.User;
import fr.ferreira.donovan.exam.repository.GameRepository;
import fr.ferreira.donovan.exam.DTO.GameDTO;
import fr.ferreira.donovan.exam.exception.NotFoundExamException;
import fr.ferreira.donovan.exam.service.interfaces.DAOServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GameService {

    private GameRepository gameRepository;

    private MapService mapService;

    private UserService userService;

    public Page<Game> findAll(Pageable pageable) {
        return this.gameRepository.findAll(pageable);
    }

    public Game getObjectById(String id) {
        Optional<Game> optionalGame = gameRepository.findById(id);
        return optionalGame.orElseThrow(() -> new NotFoundExamException("Game", "id", id));
    }

    public Game create(GameDTO gameDTO, Principal principal) {
        Game game = getObjectFromDTO(gameDTO);
        game.setCreatedAt(LocalDateTime.now());
        game.setUser(userService.getUserFromPrincipal(principal));
        return gameRepository.saveAndFlush(game);
    }

    public Game update(GameDTO gameDTO, String id) {
        Game game = new Game();
        if (id != null) {
            game = getObjectById(id);
        }
        game = getObjectFromDTO(gameDTO);
        return gameRepository.saveAndFlush(game);
    }

    public Game getObjectFromDTO(GameDTO gameDTO) {
        return getObjectFromDTO(gameDTO, new Game());
    }

    public Game getObjectFromDTO(GameDTO gameDTO, Game game) {
        game.setHasMove(gameDTO.getHasMove());
        game.setHasZoom(gameDTO.getHasZoom());
        game.setHasPan(gameDTO.getHasPan());
        game.setMaximumTime(gameDTO.getMaximumTime());
        game.setNbRounds(gameDTO.getNbRound());
        game.setMap(mapService.getObjectById(gameDTO.getMapId()));
        return game;
    }

    public List<Game> last() {
        return gameRepository.findTop10ByOrderByCreatedAtDesc();
    }

    public List<Game> scores() {
        return gameRepository.scores();
    }
}
