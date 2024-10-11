package fr.ferreira.donovan.exam.controller_api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.ferreira.donovan.exam.entity.Map;
import fr.ferreira.donovan.exam.DTO.MapDTO;
import fr.ferreira.donovan.exam.service.MapService;
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
public class MapRestController {

    private MapService mapService;

    @GetMapping(path = UrlRoute.URL_MAP)
    @JsonView(JsonViews.MapListJsonViews.class)
    public List<Map> list() {
        return this.mapService.findAll();
    }

    @GetMapping(path = UrlRoute.URL_MAP+"/best")
    @JsonView(JsonViews.MapListJsonViews.class)
    public List<Map> best() {
        return this.mapService.findAll();
    }

    @GetMapping(path = UrlRoute.URL_MAP + "/{id}")
    @JsonView(JsonViews.MapShowJsonViews.class)
    public Map show(@PathVariable Long id) {
        return this.mapService.getObjectById(id);
    }

    @PostMapping(path = UrlRoute.URL_MAP_NEW)
    public Map create(@Valid @RequestBody MapDTO mapDTO) {
        return mapService.create(mapDTO);
    }

    @PutMapping(path = UrlRoute.URL_MAP_EDIT + "/{id}")
    public Map update(@Valid @RequestBody MapDTO mapDTO, @PathVariable Long id) {
        return mapService.update(mapDTO, id);
    }

}