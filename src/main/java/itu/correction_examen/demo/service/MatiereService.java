package itu.correction_examen.demo.service;

import itu.correction_examen.demo.entity.Matiere;
import itu.correction_examen.demo.repositories.MatiereRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereService {

    private final MatiereRepository matiereRepository;

    public MatiereService(MatiereRepository matiereRepository) {
        this.matiereRepository = matiereRepository;
    }
    @Transactional
    public List<Matiere> findAll() {return matiereRepository.findAll();}

}
