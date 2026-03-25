package itu.correction_examen.demo.service;

import itu.correction_examen.demo.entity.Etudiant;
import itu.correction_examen.demo.entity.Matiere;
import itu.correction_examen.demo.entity.Note;
import itu.correction_examen.demo.entity.Parametre;
import itu.correction_examen.demo.record.RecordNoteCorrecteur;
import itu.correction_examen.demo.repositories.NoteRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {

    private final ParametreService parametreService;
    private final OperateurService operateurService;
    private final ResolutionService resolutionService;
    private final NoteRepository noteRepository;

    public NoteService(ParametreService parametreService,
                       OperateurService operateurService,
                       ResolutionService resolutionService,
                       NoteRepository noteRepository) {
        this.parametreService = parametreService;
        this.operateurService = operateurService;
        this.resolutionService = resolutionService;
        this.noteRepository = noteRepository;
    }

    public RecordNoteCorrecteur findNoteFinale(Etudiant etudiant, Matiere matiere){

        List<Note> notes = noteRepository.findAllByEtudiantAndMatiere(etudiant, matiere);
        System.out.println(notes.size());
        List<Parametre> parametres =
                parametreService.findParamDuNote(matiere);

        BigDecimal difference = BigDecimal.ZERO;

        for (Note note : notes) {

            difference = difference
                    .subtract(note.getNote())
                    .abs();

        }

        difference = difference.setScale(2, RoundingMode.HALF_UP);

        System.out.println("+++++++++++++++++++ " + difference);
        System.out.println("+++++++++++++++++++"+difference);
        if (parametres.size() > 0) {

            for (Parametre parametre : parametres) {

                boolean verifSiParametreOk = operateurService.verifierSiParamNoteVrai(difference, parametre);

                if (verifSiParametreOk) {

                    Note note1 = resolutionDuParam(parametre, notes);
                    RecordNoteCorrecteur record = new RecordNoteCorrecteur(notes.get(0).getCorrecteur(), note1.getNote());
                    return record;
                }

            }
        }
        return null;
    }

    private Note resolutionDuParam (Parametre parametre, List<Note> notes) {

        Note note = new Note();


        if (parametre.getResolution().getResolution().equals("GRAND")){

            return plusGrand(notes);

        } else if (parametre.getResolution().getResolution().equals("PETIT")) {
            return plusPetit(notes);
        } else if (parametre.getResolution().getResolution().equals("MOYENNE")) {

            note = moyenne(notes);
            note.setCorrecteur(notes.get(0).getCorrecteur());
            note.setEtudiant(notes.get(0).getEtudiant());
            note.setMatiere(notes.get(0).getMatiere());

            return note;
        }

        return note;
    }

    public Note plusGrand(List<Note> notes) {

        Note noteTemp = notes.get(0);

        for (Note note : notes) {
            if (note.getNote().compareTo(noteTemp.getNote()) > 0) {
                noteTemp = note;
            }
        }

        return noteTemp;
    }

    public Note plusPetit(List<Note> notes) {

        Note noteTemp = notes.get(0);

        for (Note note : notes) {
            if (note.getNote().compareTo(noteTemp.getNote()) < 0) {
                noteTemp = note;
            }
        }

        return noteTemp;
    }

    public Note moyenne(List<Note> notes) {

        Note noteF = new Note();

        if (notes == null || notes.isEmpty()) {
            return null;
        }


        BigDecimal somme = BigDecimal.ZERO;

        for (Note note : notes) {
            somme = somme.add(note.getNote());
        }
        BigDecimal rep = somme.divide(
                BigDecimal.valueOf(notes.size()),
                2,
                RoundingMode.HALF_UP);
        noteF.setNote(rep);

        return noteF;

    }

}