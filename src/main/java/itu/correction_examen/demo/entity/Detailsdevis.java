
package itu.correction_examen.demo.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detailsdevis")
@Getter @Setter @NoArgsConstructor
public class Detailsdevis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "libelle")
    private String libelle;


    @ManyToOne
    @JoinColumn(name = "iddevis") 
    private Devis devis;
 
    
    @Column(name = "qte")
    private int qte;

    @Column(name = "pu")
    private BigDecimal pu;



}