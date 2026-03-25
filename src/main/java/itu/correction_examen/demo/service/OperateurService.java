package itu.correction_examen.demo.service;

import itu.correction_examen.demo.entity.Note;
import itu.correction_examen.demo.entity.Operateur;
import itu.correction_examen.demo.entity.Parametre;
import itu.correction_examen.demo.repositories.OperateurRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OperateurService {

    private final OperateurRepository operateurRepository;

    public OperateurService(OperateurRepository operateurRepository) {
        this.operateurRepository = operateurRepository;
    }
    @Transactional
    public List<Operateur> findAll() {
        return operateurRepository.findAll();
    }

    public boolean verifierSiParamNoteVrai(BigDecimal note, Parametre parametre) {
        String resultat = "";
        BigDecimal a = note;
        BigDecimal b = parametre.getDiff();
        if (parametre.getOperateur().getOperateur().equals("<")) {

            if (b.compareTo(a) < 0) {
                return true;
            }

        } else if (parametre.getOperateur().getOperateur().equals("<=")) {
            if (b.compareTo(a) <= 0)return true;

        } else if (parametre.getOperateur().getOperateur().equals(">")) {
            if (b.compareTo(a) > 0) return true;
        } else if (parametre.getOperateur().getOperateur().equals(">=")) {
            if (b.compareTo(a) >= 0) return true;
        }

        return false;
    }

}
