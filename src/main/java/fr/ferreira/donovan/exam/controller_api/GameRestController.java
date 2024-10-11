package fr.ferreira.donovan.exam.controller_api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.ferreira.donovan.exam.entity.Game;
import fr.ferreira.donovan.exam.DTO.GameDTO;
import fr.ferreira.donovan.exam.service.GameService;
import fr.ferreira.donovan.exam.json_views.JsonViews;
import fr.ferreira.donovan.exam.mapping.UrlRoute;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(UrlRoute.URL_API)
public class GameRestController {

    private GameService gameService;

    @GetMapping(path = UrlRoute.URL_GAME)
    @JsonView(JsonViews.GameListJsonViews.class)
    public List<Game> list() {
        return this.gameService.findAll();
    }

    @GetMapping(path = UrlRoute.URL_GAME + "/scores")
    @JsonView(JsonViews.GameListJsonViews.class)
    public List<Game> scores() {
        return this.gameService.findAll();
    }

    @GetMapping(path = UrlRoute.URL_GAME + "/last")
    @JsonView(JsonViews.GameListJsonViews.class)
    public List<Game> last() {
        return this.gameService.findAll();
    }

    @GetMapping(path = UrlRoute.URL_GAME + "/{id}")
    @JsonView(JsonViews.GameShowJsonViews.class)
    public Game show(@PathVariable String id) {
        return this.gameService.getObjectById(id);
    }

    @PostMapping(path = UrlRoute.URL_GAME_NEW)
    public Game create(@Valid @RequestBody GameDTO gameDTO, Principal principal) {
        return gameService.create(gameDTO, principal);
    }
}