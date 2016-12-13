package com.courses.spalah.persistence;

import com.courses.spalah.domain.Flight;

import java.util.List;

/**
 * Created by Roman on 24.11.2016.
 */
public interface Dao<E, I> {
    E getById(I id);

    E save(E entity);

    List<E> getAll();

    E delete(I id);

    E update(E entity);
}
