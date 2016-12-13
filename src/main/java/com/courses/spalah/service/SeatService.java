package com.courses.spalah.service;

import com.courses.spalah.domain.Seat;

import java.util.List;

/**
 * Created by Roman on 22.11.2016.
 */
public interface SeatService {

    Seat getById(Long id);

    Seat save(Seat seat);

    List<Seat> getAll();

    Seat delete(Long id);

    Seat update(Seat seat);
}
