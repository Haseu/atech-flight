package br.com.atech.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by andre on 10/12/2017.
 */
@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue
    private Long id;
    private Date departureTime;
    private Date arrivalTime;
    @OneToOne(fetch = FetchType.EAGER)
    private City departureCity;
    @OneToOne(fetch = FetchType.EAGER)
    private City arrivalCity;
    @OneToOne(fetch = FetchType.EAGER)
    private Airplane airplane;
    @OneToOne(fetch = FetchType.EAGER)
    private Pilot pilot;
    @OneToOne(fetch = FetchType.EAGER)
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public City getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(City departureCity) {
        this.departureCity = departureCity;
    }

    public City getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(City arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
