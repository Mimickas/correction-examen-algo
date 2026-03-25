package itu.correction_examen.demo.service;

import itu.correction_examen.demo.entity.Etudiant;
import itu.correction_examen.demo.entity.NoteFinale;
import itu.correction_examen.demo.repositories.NoteFinaleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteFinaleService {

    private final NoteFinaleRepository noteFinaleRepository;

    public NoteFinaleService(final NoteFinaleRepository noteFinaleRepository) {
        this.noteFinaleRepository = noteFinaleRepository;
    }
    @Transactional
    public void save(final NoteFinale noteFinale) {
        noteFinaleRepository.save(noteFinale);
    }
}
