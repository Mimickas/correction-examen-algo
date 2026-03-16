package itu.correction_examen.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "correcteur")
public class Correcteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    // Relation One-to-Many avec Note
    @OneToMany(mappedBy = "correcteur", fetch = FetchType.LAZY)
    @JsonIgnore  // ← AJOUTE ÇA !
    private List<Note> notes;

    // Constructeurs
    public Correcteur() {}

    public Correcteur(String nom) {
        this.nom = nom;
    }

    // Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}