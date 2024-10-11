package fr.ferreira.donovan.exam.service;

import fr.ferreira.donovan.exam.entity.Map;
import fr.ferreira.donovan.exam.repository.MapRepository;
import fr.ferreira.donovan.exam.DTO.MapDTO;
import fr.ferreira.donovan.exam.exception.NotFoundExamException;
import fr.ferreira.donovan.exam.service.interfaces.DAOServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MapService implements DAOServiceInterface<Map, MapDTO, Long> {

    private MapRepository mapRepository;

    public List<Map> findAll() {
        return this.mapRepository.findAll();
    }

    public Map getObjectById(Long id) {
        Optional<Map> optionalMap = mapRepository.findById(id);
        return optionalMap.orElseThrow(() -> new NotFoundExamException("Map", "id", id));
    }

    public Map create(MapDTO mapDTO) {
        Map map = getObjectFromDTO(mapDTO);
        // TODO complete dto -> object
        return mapRepository.saveAndFlush(map);
    }

    public Map update(MapDTO mapDTO, Long id) {
        Map map = new Map();
        if (id != null) {
            map = getObjectById(id);
        }
        map = getObjectFromDTO(mapDTO);
        // TODO complete dto -> object
        return mapRepository.saveAndFlush(map);
    }

    public Map getObjectFromDTO(MapDTO mapDTO) {
        return getObjectFromDTO(mapDTO, new Map());
    }

    public Map getObjectFromDTO(MapDTO mapDTO, Map map) {
        // TODO Complete
        return map;
    }
}
