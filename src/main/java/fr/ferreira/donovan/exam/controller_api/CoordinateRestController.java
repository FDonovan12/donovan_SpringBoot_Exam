package fr.ferreira.donovan.exam.controller_api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.ferreira.donovan.exam.entity.Coordinate;
import fr.ferreira.donovan.exam.DTO.CoordinateDTO;
import fr.ferreira.donovan.exam.service.CoordinateService;
import fr.ferreira.donovan.exam.json_views.JsonViews;
import fr.ferreira.donovan.exam.mapping.UrlRoute;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(UrlRoute.URL_API)
public class CoordinateRestController {

    private CoordinateService coordinateService;

    @PostMapping(path = UrlRoute.URL_COORDINATE_NEW)
    @JsonView(JsonViews.CoordinateShowJsonViews.class)
    public Coordinate create(@Valid @RequestBody CoordinateDTO coordinateDTO) {
        return coordinateService.create(coordinateDTO);
    }
}