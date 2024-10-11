package fr.ferreira.donovan.exam.controller_api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.ferreira.donovan.exam.DTO.MapDTO;
import fr.ferreira.donovan.exam.DTO.RoundUpdateDTO;
import fr.ferreira.donovan.exam.entity.Map;
import fr.ferreira.donovan.exam.entity.Round;
import fr.ferreira.donovan.exam.DTO.RoundDTO;
import fr.ferreira.donovan.exam.service.RoundService;
import fr.ferreira.donovan.exam.json_views.JsonViews;
import fr.ferreira.donovan.exam.mapping.UrlRoute;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(UrlRoute.URL_API)
public class RoundRestController {

    private RoundService roundService;

    @PostMapping(path = UrlRoute.URL_ROUND_NEW)
    @JsonView(JsonViews.RoundShowJsonViews.class)
    public Round create(@Valid @RequestBody RoundDTO roundDTO) {
        return roundService.create(roundDTO);
    }

    @PutMapping(path = UrlRoute.URL_ROUND_EDIT + "/{id}")
    @JsonView(JsonViews.MapShowJsonViews.class)
    public Round update(@Valid @RequestBody RoundUpdateDTO roundDTO, @PathVariable Long id) {
        return roundService.update(roundDTO, id);
    }
}