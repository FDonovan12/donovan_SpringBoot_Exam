package fr.ferreira.donovan.exam.repository;

import fr.ferreira.donovan.exam.entity.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MapRepository extends JpaRepository<Map, Long> {

}