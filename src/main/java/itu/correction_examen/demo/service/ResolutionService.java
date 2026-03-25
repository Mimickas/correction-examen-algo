package itu.correction_examen.demo.service;

import itu.correction_examen.demo.entity.Parametre;
import itu.correction_examen.demo.entity.Resolution;
import itu.correction_examen.demo.repositories.ResolutionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResolutionService {

    private ResolutionRepository resolutionRepository;

    public ResolutionService(ResolutionRepository resolutionRepository) {
        this.resolutionRepository = resolutionRepository;
    }

    @Transactional
    public List<Resolution> findAll() {return resolutionRepository.findAll();}
}
