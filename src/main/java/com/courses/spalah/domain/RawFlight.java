package com.courses.spalah.domain;

/**
 * Created by Roman on 24.11.2016.
 */
public class RawFlight {
    private Long id;
    private String flightNumber;
    private Long currentPlane;
    private Long departure;
    private Long arrival;
    private String departureDate;
    private String arrivalDate;
    private String departureDate2;
    private String arrivalDate2;
    private Double priceCasual;
    private Double priceBusiness;

    public RawFlight() {
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

    public Long getCurrentPlane() {
        return currentPlane;
    }

    public void setCurrentPlane(Long currentPlane) {
        this.currentPlane = currentPlane;
    }

    public Long getDeparture() {
        return departure;
    }

    public void setDeparture(Long departure) {
        this.departure = departure;
    }

    public Long getArrival() {
        return arrival;
    }

    public void setArrival(Long arrival) {
        this.arrival = arrival;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureDate2() {
        return departureDate2;
    }

    public void setDepartureDate2(String departureDate2) {
        this.departureDate2 = departureDate2;
    }

    public String getArrivalDate2() {
        return arrivalDate2;
    }

    public void setArrivalDate2(String arrivalDate2) {
        this.arrivalDate2 = arrivalDate2;
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
        return "RawFlight{" +
                "id=" + id +
                ", flightNumber='" + flightNumber + '\'' +
                ", currentPlane=" + currentPlane +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", departureDate='" + departureDate + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", departureDate2='" + departureDate2 + '\'' +
                ", arrivalDate2='" + arrivalDate2 + '\'' +
                ", priceCasual='" + priceCasual + '\'' +
                ", priceBusiness='" + priceBusiness + '\'' +
                '}';
    }
}
