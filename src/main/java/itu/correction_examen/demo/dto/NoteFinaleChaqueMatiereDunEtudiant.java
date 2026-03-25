package itu.correction_examen.demo.dto;

import itu.correction_examen.demo.entity.Correcteur;
import itu.correction_examen.demo.entity.Etudiant;
import itu.correction_examen.demo.entity.Matiere;

import java.math.BigDecimal;

public class NoteFinaleChaqueMatiereDunEtudiant {

    public Correcteur correcteur;
    public BigDecimal note;
    public Matiere matiere;
    public Etudiant etudiant;


    public Correcteur getCorrecteur() {
        return correcteur;
    }

    public void setCorrecteur(Correcteur correcteur) {
        this.correcteur = correcteur;
    }

    public BigDecimal getNote() {
        return note;
    }

    public void setNote(BigDecimal note) {
        this.note = note;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public NoteFinaleChaqueMatiereDunEtudiant(Correcteur correcteur, BigDecimal note, Matiere matiere, Etudiant etudiant) {
        this.correcteur = correcteur;
        this.note = note;
        this.matiere = matiere;
        this.etudiant = etudiant;
    }
}
