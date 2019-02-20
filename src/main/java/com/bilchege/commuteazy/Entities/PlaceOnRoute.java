package com.bilchege.commuteazy.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "place_in_route")
public class PlaceOnRoute {

    @Id
    @Column(name = "placeID")
    private String placeID;
    @Column(name = "Name")
    private String address;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;

    @ManyToMany(targetEntity = Operator.class,fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE},mappedBy = "placesSet")
    private Set<Operator> operators = new HashSet<>();

    public PlaceOnRoute() {
    }

    public PlaceOnRoute(String placeID, String address, double latitude, double longitude, Set operators) {
        this.placeID = placeID;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.operators = operators;
    }

    public String getPlaceID() {
        return placeID;
    }

    public Set getOperators() {
        return operators;
    }

    public void setOperators(Set operators) {
        this.operators = operators;
    }

    public void setPlaceID(String placeID) {
        this.placeID = placeID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
