package com.courses.spalah.persistence;

import com.courses.spalah.domain.Location;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Roman on 22.11.2016.
 */
public class LocationDao implements Dao<Location, Long> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Location getById(Long id) {
        return entityManager.find(Location.class, id);
    }

    @Override
    public Location save(Location entity) {
        return null;
    }

    @Override
    public List<Location> getAll() {
        List<Location> locations = entityManager.createQuery("from location", Location.class).getResultList();
        return locations;
    }

    @Override
    public Location delete(Long id) {
        return null;
    }

    @Override
    public Location update(Location entity) {
        return null;
    }

}
