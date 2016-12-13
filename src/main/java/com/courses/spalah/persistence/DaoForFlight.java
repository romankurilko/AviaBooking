package com.courses.spalah.persistence;

import java.util.List;

/**
 * Created by Roman on 24.11.2016.
 */

public interface DaoForFlight<E, I, R> {
    E getById(I id);

    E save(E entity);

    List<E> getAll();

    E delete(I id);

    E update(E entity);

    List<E> searchFlights(R searchedFlight);

}
