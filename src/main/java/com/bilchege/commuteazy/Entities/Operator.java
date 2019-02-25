package com.bilchege.commuteazy.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Operator {

      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Operator_id")
    //@JsonProperty("id")
    private Long operatorID;
    @Column(name = "name")
    @JsonProperty("name")
    private String operatorName;
    @Column(name = "email")
    @JsonProperty("email")
    private String email;
    @Column(name = "phone")
    @JsonProperty("phone")
    private String phone;
    @Column(name = "account_Password")
    @JsonProperty("password")
    private String accountPassword;

    @JsonIgnore
    @ManyToMany(targetEntity = PlaceOnRoute.class,fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST})
    @JoinTable(name = "operator_place",joinColumns = {@JoinColumn(name = "operatorID")},inverseJoinColumns = {@JoinColumn(name = "placeID")})
    @JsonProperty("places")
    private Set<PlaceOnRoute> placesSet = new HashSet<>();

    @ManyToMany(targetEntity = Terminus.class,fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinTable(name = "operator_terminus",joinColumns = {@JoinColumn(name = "operatorID")},inverseJoinColumns = {@JoinColumn(name = "placeID")})
    @JsonProperty("termini")
    private Set<Terminus> termini = new HashSet<>();

    public Operator() {
    }

    public Operator(Long operatorID, String operatorName, String email, String phone, String accountPassword, Set<PlaceOnRoute> placesSet, Set<Terminus> termini) {
        this.operatorName = operatorName;
        this.operatorID = operatorID;
        this.email = email;
        this.phone = phone;
        this.accountPassword = accountPassword;
        this.placesSet = placesSet;
        this.termini = termini;
    }

    public Long getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(Long operatorID) {
        this.operatorID = operatorID;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public Set<PlaceOnRoute> getPlacesSet() {
        return placesSet;
    }

    public void setPlacesSet(Set<PlaceOnRoute> placesSet) {
        this.placesSet = placesSet;
    }

    public Set<Terminus> getTermini() {
        return termini;
    }

    public void setTermini(Set<Terminus> termini) {
        this.termini = termini;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }
}
