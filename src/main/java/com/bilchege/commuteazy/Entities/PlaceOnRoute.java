package com.bilchege.commuteazy.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "place_in_route")
public class PlaceOnRoute {

    @Id
    @Column(name = "placeID")
    @JsonProperty("id")
    private String placeID;
    @Column(name = "Name")
    @JsonProperty("name")
    private String address;
    @Column(name = "latitude")
    @JsonProperty("latitude")
    private double latitude;
    @Column(name = "longitude")
    @JsonProperty("longitude")
    private double longitude;

    @JsonIgnore
    @ManyToMany(mappedBy = "placesSet")
    private Set<Operator> operators = new HashSet<>();

    public PlaceOnRoute() {
    }

    public PlaceOnRoute(String placeID, String address, double latitude, double longitude, Set<Operator> operators) {
        this.placeID = placeID;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.operators = operators;
    }

    public String getPlaceID() {
        return placeID;
    }

    public Set<Operator> getOperators() {
        return operators;
    }

    public void setOperators(Set<Operator> operators) {
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