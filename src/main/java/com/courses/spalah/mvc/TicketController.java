package com.courses.spalah.mvc;

import com.courses.spalah.domain.Ticket;
import com.courses.spalah.domain.TicketRequest;
import com.courses.spalah.service.FlightService;
import com.courses.spalah.service.PersonService;
import com.courses.spalah.service.SeatService;
import com.courses.spalah.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Roman on 24.11.2016.
 */

@RestController
@RequestMapping(value = "/ticket", produces = MediaType.APPLICATION_JSON_VALUE)
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private PersonService personService;

    @Autowired
    private SeatService seatService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Ticket> getTicket(@RequestParam Long id) {
        Ticket idTicket = ticketService.getById(id);
        return new ResponseEntity<Ticket>(idTicket, HttpStatus.OK);
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public ResponseEntity<List<Ticket>> getAllTickets(@RequestParam Long flight) {
        List<Ticket> tickets = ticketService.getAll(flight);
        return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResponseEntity<Ticket> deleteFlight(@RequestParam Long id) {
        Ticket deletedTicket = ticketService.delete(id);
        return new ResponseEntity<Ticket>(deletedTicket,HttpStatus.OK);
    }

    @RequestMapping(value = "save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Ticket> saveTicket(@RequestBody TicketRequest ticketRequest) {
        Ticket newTicket = new Ticket();
        if(ticketService.checkTicket(ticketRequest))
            return new ResponseEntity<Ticket>(newTicket, HttpStatus.BAD_REQUEST);
        newTicket = ticketService.save(ticketRequest);
        return new ResponseEntity<Ticket>(newTicket, HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Ticket> updateTicket(@RequestParam Long id, @RequestBody TicketRequest ticketRequest) {
        Ticket updatedTicket = ticketService.getById(id);
        if(updatedTicket.getState() == null || updatedTicket.getState() == 1 || updatedTicket.getState() == 2) {
            return new ResponseEntity<Ticket>(updatedTicket, HttpStatus.BAD_REQUEST);
        }

        updatedTicket = ticketService.update(id, ticketRequest);
        return new ResponseEntity<Ticket>(updatedTicket, HttpStatus.OK);
    }
}
