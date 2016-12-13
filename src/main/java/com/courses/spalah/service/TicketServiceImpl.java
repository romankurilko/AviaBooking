package com.courses.spalah.service;

import com.courses.spalah.domain.Ticket;
import com.courses.spalah.domain.TicketRequest;
import com.courses.spalah.persistence.Dao;
import com.courses.spalah.persistence.DaoForTicket;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Roman on 24.11.2016.
 */
public class TicketServiceImpl implements TicketService{
    private final DaoForTicket<Ticket, Long, TicketRequest> ticketDao;

    @Autowired
    private PersonService personService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private FlightService flightService;


    public TicketServiceImpl(DaoForTicket<Ticket, Long, TicketRequest> ticketDao) {
        this.ticketDao = ticketDao;
    }

    @Override
    public Ticket getById(Long id) {
        return ticketDao.getById(id);
    }

    @Override
    public Ticket save(TicketRequest ticketRequest) {
        Ticket savedTicket = new Ticket();
        savedTicket.setPerson(personService.getById(ticketRequest.getPerson()));
        savedTicket.setSeat(seatService.getById(ticketRequest.getSeat()));
        savedTicket.setFlight(flightService.getById(ticketRequest.getFlight()));
        savedTicket.setState(ticketRequest.getState());
        savedTicket.setLuggage(ticketRequest.getLuggage());
        return ticketDao.save(savedTicket);
    }

    @Override
    public List<Ticket> getAll(Long flight) {
        return ticketDao.getAll(flight);
    }

    @Override
    public Ticket delete(Long id) {
        return ticketDao.delete(id);
    }

    @Override
    public Ticket update(Long id, TicketRequest ticketRequest) {
        Ticket updatedTicked = getById(id);
        updatedTicked.setFlight(flightService.getById(ticketRequest.getFlight()));
        updatedTicked.setLuggage(ticketRequest.getLuggage());
        updatedTicked.setSeat(seatService.getById(ticketRequest.getSeat()));
        updatedTicked.setState(ticketRequest.getState());
        updatedTicked.setPerson(personService.getById(ticketRequest.getPerson()));
        return ticketDao.update(updatedTicked);
    }

    @Override
    public Boolean checkTicket(TicketRequest ticket) {
        return ticketDao.checkTicket(ticket);
    }
}
