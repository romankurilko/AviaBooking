package com.courses.spalah.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Roman on 19.11.2016.
 */

@Entity(name = "ticket")
public class Ticket {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = true)
    @JsonBackReference
    private Seat seat;

    @Column(name = "luggage")
    private Long luggage;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = true)
    @JsonIgnore
    private Flight flight;

    @Column(name = "state")
    private Long state;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = true)
    private Person person;

    public Ticket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getLuggage() {
        return luggage;
    }

    public void setLuggage(Long luggage) {
        this.luggage = luggage;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", seat=" + seat +
                ", luggage=" + luggage +
                ", flight=" + flight +
                ", state=" + state +
                ", person=" + person +
                '}';
    }
}
