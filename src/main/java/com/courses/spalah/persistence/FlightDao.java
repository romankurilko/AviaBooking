package com.courses.spalah.persistence;

import com.courses.spalah.domain.Flight;
import com.courses.spalah.domain.RawFlight;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 * Created by Roman on 24.11.2016.
 */
@Transactional
public class FlightDao implements DaoForFlight<Flight, Long, RawFlight> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Flight getById(Long id) {
        return entityManager.find(Flight.class, id);
    }

    @Override
    public Flight save(Flight flight) {
        entityManager.persist(flight);
        return flight;
    }

    @Override
    public List<Flight> getAll() {
        List<Flight> flights = entityManager.createQuery("from flight", Flight.class).getResultList();
        return flights;
    }

    @Override
    public Flight delete(Long id) {
        Flight deletedFlight = entityManager.find(Flight.class, id);
        entityManager.remove(deletedFlight);
        return deletedFlight;
    }

    @Override
    public Flight update(Flight flight) {
        entityManager.merge(flight);
        return flight;
    }
    @Override
    public List<Flight> searchFlights(RawFlight searchedFlight) {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Session session =   entityManager.unwrap(Session.class);
        Criteria crit = session.createCriteria(Flight.class);
        if(Long.class.isInstance(searchedFlight.getId()))
            crit.add(Restrictions.eq("id", searchedFlight.getId()));
        if(searchedFlight.getFlightNumber() != null)
            crit.add(Restrictions.eq("flightNumber", new String(searchedFlight.getFlightNumber())));
        if(searchedFlight.getArrivalDate() != null && searchedFlight.getArrivalDate2() != null)
            try {
                crit.add(Restrictions.between("arrivalDate",formatter.parseObject(searchedFlight.getArrivalDate()),formatter.parseObject(searchedFlight.getArrivalDate2())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        if(searchedFlight.getDepartureDate() != null && searchedFlight.getDepartureDate2() != null)
            try {
                crit.add(Restrictions.between("departureDate",formatter.parseObject(searchedFlight.getDepartureDate()),formatter.parseObject(searchedFlight.getDepartureDate2())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        if(String.class.isInstance(searchedFlight.getArrival()))
            crit.add(Restrictions.eq("arrival",searchedFlight.getArrival()));
        if(String.class.isInstance(searchedFlight.getDeparture()))
            crit.add(Restrictions.eq("departure",searchedFlight.getDeparture()));
        crit.setResultTransformer(crit.DISTINCT_ROOT_ENTITY);
        return crit.list();
    }
}
