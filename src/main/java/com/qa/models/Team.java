package com.qa.models;

import javax.persistence.*;

@Entity
@Table(name="footyteams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String team;
    String location;
    String stadium;

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.team = name;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setStadium(String stadium) {
        this.stadium = stadium;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return team;
    }
    public String getLocation() {
        return location;
    }
    public String getStadium() {
        return stadium;
    }
}
