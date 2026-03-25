package itu.correction_examen.demo.service;

import itu.correction_examen.demo.entity.Matiere;
import itu.correction_examen.demo.entity.Note;
import itu.correction_examen.demo.entity.Parametre;
import itu.correction_examen.demo.repositories.ParametreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParametreService {

    private final ParametreRepository parametreRepository;

    public ParametreService(ParametreRepository repo) {
        this.parametreRepository = repo;
    }
    @Transactional
    public List<Parametre> findAll() {return parametreRepository.findAll();}
    @Transactional
    public List<Parametre> findParamDuNote(Matiere matiere) {
        return parametreRepository.findByMatiere(matiere);
    }

}
