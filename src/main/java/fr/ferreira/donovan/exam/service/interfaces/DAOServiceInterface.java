package fr.ferreira.donovan.exam.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DAOServiceInterface<T, C, I> {

    List<T> findAll();

    T getObjectById(I id);

    T create(C dto);

    T update(C dto, I id);
}
