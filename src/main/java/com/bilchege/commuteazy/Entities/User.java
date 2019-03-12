package com.bilchege.commuteazy.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "first_name")
    @JsonProperty("firstName")
    private String firstName;
    @Column(name = "last_name")
    @JsonProperty("lastName")
    private String lastName;
    @Column(name = "user_name")
    @JsonProperty("userName")
    private String userName;
    @Column(name = "phone")
    @JsonProperty("phone")
    private Long phone;
    @Column(name = "email")
    @JsonProperty("email")
    private String email;
    @Column(name = "password")
    @JsonProperty("password")
    private String accountPassword;

    public User() {

    }

    public User(String firstName, String lastName, String userName, Long phone, String email, String accountPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.phone = phone;
        this.email = email;
        this.accountPassword = accountPassword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }
}
