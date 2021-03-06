package com.bilchege.commuteazy.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonMerge;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Operator {

      @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @OneToMany(mappedBy = "operator")
    @JsonIgnore
    private List<Feed> updateFeeds = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.MERGE},fetch = FetchType.EAGER)
    @JsonMerge
    @JsonIgnore
    @JoinTable(name = "operator_place",joinColumns = {@JoinColumn(name = "operatorID")},inverseJoinColumns = {@JoinColumn(name = "placeID")})
    @JsonProperty("places")
    private Set<PlaceOnRoute> places = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.MERGE},fetch = FetchType.EAGER)
    @JsonMerge
    @JsonIgnore
    @JoinTable(name = "operator_terminus",joinColumns = {@JoinColumn(name = "operatorID")},inverseJoinColumns = {@JoinColumn(name = "placeID")})
    @JsonProperty("termini")
    private Set<Terminus> termini = new HashSet<>();

    public Operator() {
    }

    public Operator(String operatorName, String email, String phone, String accountPassword, Set<PlaceOnRoute> places, Set<Terminus> termini, @Nullable List<Review> reviews) {
        this.operatorName = operatorName;
        this.email = email;
        this.phone = phone;
        this.accountPassword = accountPassword;
        this.places = places;
        this.termini = termini;
        //this.reviews = reviews;
    }

    public List<Feed> getUpdateFeeds() {
        return updateFeeds;
    }

    public void setUpdateFeeds(List<Feed> updateFeeds) {
        this.updateFeeds = updateFeeds;
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

    public Set<PlaceOnRoute> getPlaces() {
        return places;
    }

    public void setPlaces(Set<PlaceOnRoute> places) {
        this.places = places;
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
