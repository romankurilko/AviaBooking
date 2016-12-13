package com.courses.spalah.service;

import com.courses.spalah.domain.*;
import com.courses.spalah.persistence.Dao;
import com.courses.spalah.persistence.DaoForFlight;
import com.courses.spalah.persistence.DaoForTicket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Roman on 24.11.2016.
 */
@Configuration
public class ServiceConfiguration {
    @Bean
    PersonService personService(Dao<Person, Long> personDao) {
        return new PersonServiceImpl(personDao);
    }

    @Bean
    PlaneService planeService(Dao<Plane, Long> planeDao) {
        return new PlaneServiceImpl(planeDao);
    }

    @Bean
    SeatService seatService(Dao<Seat, Long> seatDao) {
        return new SeatServiceImpl(seatDao);
    }

    @Bean
    LocationService locationService(Dao<Location, Long> locationDao) {
        return new LocationServiceImpl(locationDao);
    }

    @Bean
    TicketService ticketService(DaoForTicket<Ticket, Long, TicketRequest> ticketDao) {
        return new TicketServiceImpl(ticketDao);
    }

    @Bean
    FlightService flightService(DaoForFlight<Flight, Long, RawFlight> flightDao) {
        return new FlightServiceImpl(flightDao);
    }
}
