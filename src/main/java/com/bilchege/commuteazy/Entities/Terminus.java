package com.bilchege.commuteazy.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "terminus")
public class Terminus {

    @Id
    @Column(name = "placeID")
    private String placeID;
    @Column(name = "Address")
    private String name;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;

    @ManyToMany(targetEntity = Operator.class,fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE},mappedBy = "termini")
    private Set<Operator> operators;

    public Terminus() {
    }

    public Terminus(String placeID, String name, double latitude, double longitude, Set operators) {
        this.placeID = placeID;
        this.name = name;
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
