package fr.ferreira.donovan.exam.repository;

import fr.ferreira.donovan.exam.entity.Round;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundRepository extends JpaRepository<Round, Long> {

}