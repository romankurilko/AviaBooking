package com.courses.spalah.persistence;

import java.util.List;

/**
 * Created by Roman on 25.11.2016.
 */

public interface DaoForTicket<E, I, R> {
    E getById(I id);

    E save(E entity);

    List<E> getAll(I flight);

    E delete(I id);

    E update(E entity);

    Boolean checkTicket(R ticket);
}