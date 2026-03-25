package itu.correction_examen.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "operateur")
public class Operateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "operateur", nullable = false, length = 10)
    private String operateur;

    // Constructeurs
    public Operateur() {}

    public Operateur(String operateur) {
        this.operateur = operateur;
    }

    // Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperateur() {
        return operateur;
    }

    public void setOperateur(String operateur) {
        this.operateur = operateur;
    }
}