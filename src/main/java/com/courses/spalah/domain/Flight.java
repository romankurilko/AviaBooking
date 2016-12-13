package com.courses.spalah.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Roman on 17.11.2016.
 */

@Entity(name = "flight")
public class Flight {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "flight_number")
    private String flightNumber;

    @ManyToOne
    @JoinColumn(name = "plane_id", nullable = true)
    @JsonManagedReference
    private Plane currentPlane;

    @ManyToOne
    @JoinColumn(name = "departure_id", nullable = true)
    @JsonManagedReference
    private Location departure;

    @ManyToOne
    @JoinColumn(name = "arrival_id", nullable = true)
    @JsonManagedReference
    private Location arrival;

    @Column(name = "departure_date")
    private Date departureDate;

    @Column(name = "arrival_date")
    private Date arrivalDate;

    @Column(name = "price_casual")
    private Double priceCasual;

    @Column(name = "price_business")
    private Double priceBusiness;

    public Flight() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Plane getCurrentPlane() {
        return currentPlane;
    }

    public void setCurrentPlane(Plane currentPlane) {
        this.currentPlane = currentPlane;
    }

    public Location getDeparture() {
        return departure;
    }

    public void setDeparture(Location departure) {
        this.departure = departure;
    }

    public Location getArrival() {
        return arrival;
    }

    public void setArrival(Location arrival) {
        this.arrival = arrival;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Double getPriceCasual() {
        return priceCasual;
    }

    public void setPriceCasual(Double priceCasual) {
        this.priceCasual = priceCasual;
    }

    public Double getPriceBusiness() {
        return priceBusiness;
    }

    public void setPriceBusiness(Double priceBusiness) {
        this.priceBusiness = priceBusiness;
    }

    @Override
    public String toString() {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "Flight{" +
                "id=" + id +
                ", flightNumber='" + flightNumber + '\'' +
                ", currentPlane=" + currentPlane.getPlaneName() +
                ", departure=" + departure.getCity() +
                ", arrival=" + arrival.getCity() +
                ", departureDate=" + formatter.format(departureDate) +
                ", arrivalDate=" + formatter.format(arrivalDate) +
                ", priceCasual=" + priceCasual +
                ", priceBusiness=" + priceBusiness +
                '}';
    }
}
