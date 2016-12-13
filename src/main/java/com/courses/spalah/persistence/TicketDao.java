package com.courses.spalah.persistence;

import com.courses.spalah.domain.Ticket;
import com.courses.spalah.domain.TicketRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.lang.NullPointerException;

/**
 * Created by Roman on 24.11.2016.
 */
@Transactional
public class TicketDao implements DaoForTicket<Ticket, Long, TicketRequest> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Ticket getById(Long id) {
        return entityManager.find(Ticket.class, id);
    }

    @Override
    public Ticket save(Ticket ticket) {
        entityManager.persist(ticket);
        return ticket;
    }

    @Override
    public List<Ticket> getAll(Long flight) {
        TypedQuery<Ticket> query = entityManager.createQuery(
                "SELECT c FROM ticket c WHERE flight_id = :flightt", Ticket.class);
        List<Ticket> tickets = query.setParameter("flightt", flight).getResultList();
        return tickets;
    }

    @Override
    public Ticket delete(Long id) {
        Ticket deletedTicket = entityManager.find(Ticket.class, id);
        entityManager.remove(deletedTicket);
        return deletedTicket;
    }

    @Override
    public Ticket update(Ticket ticket) {
        return entityManager.merge(ticket);
    }

    @Override
    public Boolean checkTicket(TicketRequest ticket) {
        try{
        TypedQuery<Ticket> query = entityManager.createQuery(
                "SELECT c FROM ticket c WHERE flight_id = :flightt AND seat_id = :seatt", Ticket.class);
            List<Ticket> results = query.setParameter("flightt", ticket.getFlight()).setParameter("seatt", ticket.getSeat()).getResultList();
            if (results.isEmpty())
                return false;
            else
                return true;
        } catch(NullPointerException e) {
            return false;
        }
        catch(NoResultException e2) {
            return false;
        }
    }
}
