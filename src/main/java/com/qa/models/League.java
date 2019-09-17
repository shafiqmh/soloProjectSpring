package com.qa.models;

import javax.persistence.*;

@Entity
@Table(name="leagues")
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String foundDate;

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getFoundDate() {
        return foundDate;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setFoundDate(String foundDate) {
        this.foundDate = foundDate;
    }

}
