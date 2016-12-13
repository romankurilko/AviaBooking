package com.courses.spalah.service;

import com.courses.spalah.domain.Location;

import java.util.List;

/**
 * Created by Roman on 22.11.2016.
 */
public interface LocationService {

    Location getById(long id);

    List<Location> getAll();
}
