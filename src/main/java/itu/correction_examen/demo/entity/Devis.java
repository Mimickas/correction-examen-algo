package itu.correction_examen.demo.entity;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "devis")
@Getter 
@Setter
public class Devis {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    private LocalDate date;

   
    @ManyToOne
    @JoinColumn(name = "idtypedevis") 
    private TypeDevis typeDevis;


    @ManyToOne
    @JoinColumn(name = "iddemande")
    private Demande demande;

    // Constructeurs
    public Devis() {}

}
