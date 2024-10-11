package fr.ferreira.donovan.exam.repository;

import fr.ferreira.donovan.exam.entity.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MapRepository extends JpaRepository<Map, Long> {

    @Query("SELECT m FROM Map m JOIN Game g ON g.map = m GROUP BY m ORDER BY count(g.id) DESC LIMIT 5")
    List<Map> best();
}