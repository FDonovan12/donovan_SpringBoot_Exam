package fr.ferreira.donovan.exam.repository;

import fr.ferreira.donovan.exam.entity.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoordinateRepository extends JpaRepository<Coordinate, Long> {

    @Query("SELECT c FROM Coordinate c ORDER BY RAND() LIMIT 1")
    Coordinate findRandom();
}