package com.bilchege.commuteazy.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "terminus")
public class Terminus {

    @Id
    @Column(name = "placeID")
    @JsonProperty("id")
    private String placeID;
    @Column(name = "Address")
    @JsonProperty("name")
    private String name;
    @Column(name = "latitude")
    @JsonProperty("latitude")
    private double latitude;
    @Column(name = "longitude")
    @JsonProperty("longitude")
    private double longitude;

    @JsonIgnore
    @ManyToMany(mappedBy = "termini",cascade = CascadeType.PERSIST)
    private Set<Operator> operators = new HashSet<>();

    public Terminus() {
    }

    public Terminus(String placeID, String name, double latitude, double longitude, Set<Operator> operators) {
        this.placeID = placeID;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
