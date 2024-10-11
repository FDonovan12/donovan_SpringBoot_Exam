package fr.ferreira.donovan.exam.controller_api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.ferreira.donovan.exam.entity.Map;
import fr.ferreira.donovan.exam.DTO.MapDTO;
import fr.ferreira.donovan.exam.service.MapService;
import fr.ferreira.donovan.exam.json_views.JsonViews;
import fr.ferreira.donovan.exam.mapping.UrlRoute;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public Page<Map> list(@PageableDefault(
                                        size = 12,
                                        sort = { "name" },
                                        direction = Sort.Direction.ASC)
                                        Pageable pageable) {
        return this.mapService.findAll(pageable);
    }

    @GetMapping(path = UrlRoute.URL_MAP_BEST)
    @JsonView(JsonViews.MapListJsonViews.class)
    public List<Map> best() {
        return this.mapService.best();
    }

    @GetMapping(path = UrlRoute.URL_MAP + "/{id}")
    @JsonView(JsonViews.MapShowJsonViews.class)
    public Map show(@PathVariable Long id) {
        return this.mapService.getObjectById(id);
    }

    @PostMapping(path = UrlRoute.URL_MAP_NEW)
    @JsonView(JsonViews.MapShowJsonViews.class)
    public Map create(@Valid @RequestBody MapDTO mapDTO) {
        return mapService.create(mapDTO);
    }

    @PutMapping(path = UrlRoute.URL_MAP_EDIT + "/{id}")
    @JsonView(JsonViews.MapShowJsonViews.class)
    public Map update(@Valid @RequestBody MapDTO mapDTO, @PathVariable Long id) {
        return mapService.update(mapDTO, id);
    }

}