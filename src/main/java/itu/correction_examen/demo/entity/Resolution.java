package itu.correction_examen.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "resolution")
public class Resolution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "resolution", nullable = false, length = 50)
    private String resolution;

    // Constructeurs
    public Resolution() {}

    public Resolution(String resolution) {
        this.resolution = resolution;
    }

    // Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
}