package itu.correction_examen.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client")
@Getter 
@Setter 
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "contact", nullable = false)
    private String contact;

   
    public Client(String nom, String contact) {
        this.nom = nom;
        this.contact = contact;
    }
}