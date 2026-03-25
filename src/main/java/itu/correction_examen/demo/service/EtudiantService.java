package itu.correction_examen.demo.service;

import itu.correction_examen.demo.dto.NoteFinaleChaqueMatiereDunEtudiant;
import itu.correction_examen.demo.entity.Etudiant;
import itu.correction_examen.demo.entity.Matiere;
import itu.correction_examen.demo.entity.Note;
import itu.correction_examen.demo.entity.NoteFinale;
import itu.correction_examen.demo.record.RecordNoteCorrecteur;
import itu.correction_examen.demo.repositories.EtudiantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;

    private final NoteService noteService;
    private final MatiereService matiereService;
    private final NoteFinaleService noteFinaleService;

    public EtudiantService(EtudiantRepository etudiantRepository,
                           NoteService noteService,
                           NoteFinaleService noteFinaleService,
                           MatiereService matiereService) {
        this.etudiantRepository = etudiantRepository;
        this.noteService = noteService;
        this.noteFinaleService = noteFinaleService;
        this.matiereService = matiereService;
    }
    @Transactional
    public List<Etudiant> findAll() {
        return etudiantRepository.findAll();
    }
    @Transactional
    public List<NoteFinaleChaqueMatiereDunEtudiant> findNoteFinale() throws Exception {

        List<Etudiant> etudiants = findAll();
        List<Matiere> matiereList = matiereService.findAll();
        List<NoteFinaleChaqueMatiereDunEtudiant> listeNoteFinale = new ArrayList<>();
        for (Etudiant etudiant : etudiants) {
            if (etudiant == null) {
                throw new Exception("etudiant null");
            }else{

                for (Matiere matiere : matiereList) {
                    RecordNoteCorrecteur record = noteService.findNoteFinale(etudiant, matiere);
                    NoteFinaleChaqueMatiereDunEtudiant n = new NoteFinaleChaqueMatiereDunEtudiant(record.correcteur(), record.note(), matiere, etudiant);
                    listeNoteFinale.add(n);
                }

            }

        }

        return listeNoteFinale;
    }

}
