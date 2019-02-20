package com.bilchege.commuteazy.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "operators")
public class Operator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Operator_id")
    private Long operatorID;
    @Column(name = "Name")
    private String operatorName;
    @Column(name = "Email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "accountPassword")
    private String accountPassword;

    @ManyToMany(targetEntity = PlaceOnRoute.class,fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "operator_place",joinColumns = {@JoinColumn(name = "operatorID")},inverseJoinColumns = {@JoinColumn(name = "placeID")})
    private Set<PlaceOnRoute> placesSet = new HashSet<>();

    @ManyToMany(targetEntity = Terminus.class,fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "operator_terminus",joinColumns = {@JoinColumn(name = "operatorID")},inverseJoinColumns = {@JoinColumn(name = "placeID")})
    private Set<Terminus> termini = new HashSet<>();

    public Operator() {
    }

    public Operator(Long operatorID,String operatorName, String email, String phone, String accountPassword, Set placesSet, Set termini) {
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

    public Set getPlacesSet() {
        return placesSet;
    }

    public void setPlacesSet(Set placesSet) {
        this.placesSet = placesSet;
    }

    public Set getTermini() {
        return termini;
    }

    public void setTermini(Set termini) {
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
