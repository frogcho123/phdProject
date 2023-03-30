package com.phd.phdProject.entities;
import javax.persistence.*;

@Entity
@Table(name = "sex")
public class Sex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Sex() {}

    public Sex(Long id) { this.id = id; }

    public Sex(String type) { this.type = type; }

    public Sex(Long id, String type) {
        this.id = id;
        this.type = type;
    }
}
