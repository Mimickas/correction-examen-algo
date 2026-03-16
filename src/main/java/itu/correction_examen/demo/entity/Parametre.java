package itu.correction_examen.demo.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "parametre")
public class Parametre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_matiere", nullable = false)
    private Matiere matiere;

    @Column(name = "diff", nullable = false, precision = 10, scale = 2)
    private BigDecimal diff;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_operateur", nullable = false)
    private Operateur operateur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_resolution", nullable = false)
    private Resolution resolution;

    // Constructeurs
    public Parametre() {}

    public Parametre(Matiere matiere, BigDecimal diff, Operateur operateur, Resolution resolution) {
        this.matiere = matiere;
        this.diff = diff;
        this.operateur = operateur;
        this.resolution = resolution;
    }

    // Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public BigDecimal getDiff() {
        return diff;
    }

    public void setDiff(BigDecimal diff) {
        this.diff = diff;
    }

    public Operateur getOperateur() {
        return operateur;
    }

    public void setOperateur(Operateur operateur) {
        this.operateur = operateur;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }
}