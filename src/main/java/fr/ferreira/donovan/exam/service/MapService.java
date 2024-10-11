package fr.ferreira.donovan.exam.service;

import fr.ferreira.donovan.exam.entity.Map;
import fr.ferreira.donovan.exam.repository.MapRepository;
import fr.ferreira.donovan.exam.DTO.MapDTO;
import fr.ferreira.donovan.exam.exception.NotFoundExamException;
import fr.ferreira.donovan.exam.service.interfaces.DAOServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MapService {

    private MapRepository mapRepository;

    public Page<Map> findAll(Pageable pageable) {
        return this.mapRepository.findAll(pageable);
    }

    public Map getObjectById(Long id) {
        Optional<Map> optionalMap = mapRepository.findById(id);
        return optionalMap.orElseThrow(() -> new NotFoundExamException("Map", "id", id));
    }

    public Map create(MapDTO mapDTO) {
        Map map = getObjectFromDTO(mapDTO);
        map.setCreatedAt(LocalDateTime.now());
        return mapRepository.saveAndFlush(map);
    }

    public Map update(MapDTO mapDTO, Long id) {
        Map map = new Map();
        if (id != null) {
            map = getObjectById(id);
        }
        map = getObjectFromDTO(mapDTO);
        return mapRepository.saveAndFlush(map);
    }

    public Map getObjectFromDTO(MapDTO mapDTO) {
        return getObjectFromDTO(mapDTO, new Map());
    }

    public Map getObjectFromDTO(MapDTO mapDTO, Map map) {
        map.setName(mapDTO.getName());
        return map;
    }

    public List<Map> best() {
        return mapRepository.best();
    }
}
