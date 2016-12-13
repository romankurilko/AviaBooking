package com.courses.spalah.service;

import com.courses.spalah.domain.Location;
import com.courses.spalah.persistence.Dao;

import java.util.List;

/**
 * Created by Roman on 22.11.2016.
 */
public class LocationServiceImpl implements LocationService{
    private final Dao<Location, Long> locationDao;

    public LocationServiceImpl(Dao<Location, Long> locationDao) {
        this.locationDao = locationDao;
    }

    @Override
    public Location getById(long id) {
        return locationDao.getById(id);
    }

    @Override
    public List<Location> getAll() {
        return locationDao.getAll();
    }
}
