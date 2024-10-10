package fr.ferreira.donovan.exam.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DAOServiceInterface<T, C, I> {

    Page<T> findAll(Pageable pageable);

    T getObjectById(I id);

    T persist(C dto);

    T persist(C dto, I id);
}
