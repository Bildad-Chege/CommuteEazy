package com.bilchege.commuteazy.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feed_id")
    private Long feedID;
    @Column(name = "feed")
    @JsonProperty("feed")
    private String feed;
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "date_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;

    @ManyToOne
    @JoinColumn(name = "userID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @JsonProperty("user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "operatorID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @JsonProperty("operator")
    private Operator operator;

    public Feed() {

    }

    public Feed(String feed, Date dateCreated, Date dateModified, User user, Operator operator) {
        this.feed = feed;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.user = user;
        this.operator = operator;
    }

    @PrePersist
    public void onCreate(){
        dateCreated = new Date();
    }

    @PreUpdate
    public void onUpdate(){
        dateModified = new Date();
    }

    public Long getFeedID() {
        return feedID;
    }

    public void setFeedID(Long feedID) {
        this.feedID = feedID;
    }

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
