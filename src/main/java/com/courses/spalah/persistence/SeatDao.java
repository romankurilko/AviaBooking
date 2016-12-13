package com.courses.spalah.persistence;

import com.courses.spalah.domain.Seat;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Roman on 22.11.2016.
 */
@Transactional
public class SeatDao implements Dao<Seat, Long>{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Seat getById(Long id) {
        return entityManager.find(Seat.class, id);
    }

    @Override
    public Seat save(Seat seat) {
        entityManager.persist(seat);
        return seat;
    }

    @Override
    public List<Seat> getAll() {
        List<Seat> seats = entityManager.createQuery("from seat", Seat.class).getResultList();
        return seats;
    }

    @Override
    public Seat delete(Long id) {
        Seat deletedSeat = entityManager.find(Seat.class, id);
        entityManager.remove(deletedSeat);
        return deletedSeat;
    }

    @Override
    public Seat update(Seat seat) {
        return entityManager.merge(seat);
    }
}
