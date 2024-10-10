package fr.ferreira.donovan.exam.repository.interfaces;

import java.util.Optional;

public interface EntitySlugRepository<T> {

    Optional<T> findBySlug(String slug);

}
