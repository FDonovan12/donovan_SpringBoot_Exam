package fr.ferreira.donovan.exam.repository.interfaces;

import java.util.Optional;

public interface EntityNameRepository<T> {

    Optional<T> findByName(String name);

}
