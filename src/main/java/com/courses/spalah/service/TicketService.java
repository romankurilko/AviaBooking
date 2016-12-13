package com.courses.spalah.service;

import com.courses.spalah.domain.Ticket;
import com.courses.spalah.domain.TicketRequest;

import java.util.List;

/**
 * Created by Roman on 24.11.2016.
 */

public interface TicketService {

    Ticket getById(Long id);

    Ticket save(TicketRequest ticketRequest);

    List<Ticket> getAll(Long flight);

    Ticket delete(Long id);

    Ticket update(Long id, TicketRequest ticketRequest);

    Boolean checkTicket(TicketRequest ticket);
}
