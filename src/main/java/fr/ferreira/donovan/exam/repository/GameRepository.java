package fr.ferreira.donovan.exam.repository;

import fr.ferreira.donovan.exam.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, String> {

    List<Game> findTop10ByOrderByCreatedAtDesc();

    @Query("SELECT g FROM Game g JOIN Round r ON r.game = g GROUP BY g ORDER BY sum(r.points) DESC LIMIT 10")
    List<Game> scores();
}