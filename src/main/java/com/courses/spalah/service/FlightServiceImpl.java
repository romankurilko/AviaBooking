package com.courses.spalah.service;

import com.courses.spalah.domain.Flight;
import com.courses.spalah.domain.RawFlight;
import com.courses.spalah.persistence.DaoForFlight;

import java.util.List;

/**
 * Created by Roman on 24.11.2016.
 */

public class FlightServiceImpl implements FlightService {
    private final DaoForFlight<Flight, Long, RawFlight> flightDao;

    public FlightServiceImpl(DaoForFlight<Flight, Long, RawFlight> flightDao) {
        this.flightDao = flightDao;
    }

    @Override
    public Flight getById(Long id) {
        return flightDao.getById(id);
    }

    @Override
    public Flight save(Flight flight) {
        flightDao.save(flight);
        return flight;
    }

    @Override
    public List<Flight> getAll() {
        return flightDao.getAll();
    }

    @Override
    public Flight delete(Long id) {
        return flightDao.delete(id);
    }

    @Override
    public Flight update(Flight flight) {
        return flightDao.update(flight);
    }


    public List<Flight> searchFlights(RawFlight searchedFlight) {
        return flightDao.searchFlights(searchedFlight);
    }


}