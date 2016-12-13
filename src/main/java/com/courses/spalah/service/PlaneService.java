package com.courses.spalah.service;

import com.courses.spalah.domain.Plane;

import java.util.List;

/**
 * Created by Roman on 19.11.2016.
 */
public interface PlaneService {

    Plane getById(Long id);

    Plane save(String model, Long business, Long casual);

    List<Plane> getAll();

    Plane delete(Long id);

    Plane update(Plane plane);
}
