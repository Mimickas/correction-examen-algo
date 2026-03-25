package itu.correction_examen.demo.controller;

import itu.correction_examen.demo.dto.NoteFinaleChaqueMatiereDunEtudiant;
import itu.correction_examen.demo.service.EtudiantService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/etudiant")
@CrossOrigin(origins = "http://localhost:5173")
public class EtudiantController {


    EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping("/notes")
    public List<NoteFinaleChaqueMatiereDunEtudiant> getNoteFinaleChaqueMatiereDunEtudiant() {
        try {
            return this.etudiantService.findNoteFinale();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
