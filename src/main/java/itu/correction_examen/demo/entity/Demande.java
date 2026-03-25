package itu.correction_examen.demo.entity;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "demande")
@Getter
@Setter
@NoArgsConstructor
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "lieu", nullable = false, length = 50)
    private String lieu;

    @Column(name = "date")

    @JsonFormat(pattern = "yyyy-MM-dd") 
    private LocalDate date;

    @Column(name = "district", nullable = false, length = 50)
    private String district;

    @ManyToOne
    @JoinColumn(name = "idclient")
    private Client client;

   
    public Demande(String lieu, String district, LocalDate date) {
        this.lieu = lieu;
        this.district = district;
        this.date = date;
    }
}