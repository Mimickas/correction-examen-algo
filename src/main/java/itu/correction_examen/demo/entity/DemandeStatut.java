
package itu.correction_examen.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "demandestatut")
@Getter @Setter @NoArgsConstructor
public class DemandeStatut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idstatut") 
    private Statut statut;
   
    

    @ManyToOne
    @JoinColumn(name = "iddemande")
    private Demande demande;

    @Column(name = "date")
    private LocalDate date;


}

