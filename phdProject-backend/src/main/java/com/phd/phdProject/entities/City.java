package com.phd.phdProject.entities;

import javax.persistence.*;



@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City(){ }

    public City(String name) {
        this.name = name;
    }

    public City(Long id) {
        this.id = id;
    }

    public City(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
