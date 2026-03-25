package itu.correction_examen.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import itu.correction_examen.demo.entity.Demande;
import itu.correction_examen.demo.entity.DemandeStatut;
import itu.correction_examen.demo.entity.Statut;
import itu.correction_examen.demo.repository.DemandeRepository;
import itu.correction_examen.demo.repository.DemandeStatutRepository;
import itu.correction_examen.demo.repository.StatutRepository;

@Service
public class DemandeService {

    @Autowired
    private DemandeRepository demande;

    @Autowired
    private DemandeStatutRepository demandeStatutRepo;

    @Autowired
    private StatutRepository statutRepo;

    // RÉCUPÉRER TOUT
    public List<Demande> findAll() {
        return demande.findAll();
    }

    public Demande findById(Integer id) {
        return demande.findById(id).orElse(null);
    }

    /**
     * Transaction = TOUT ou RIEN
     * Si DemandeStatut échoue → Demande aussi annulée
     */
    @Transactional
    public Demande save(Demande obj) {

        boolean isNew = (obj.getId() == null);

        // 1. Save demande
        Demande savedDemande = demande.save(obj);

        // 2. Si nouvelle demande → créer statut initial
        if (isNew) {
            createInitialStatut(savedDemande);
        }

        return savedDemande;
    }

    private void createInitialStatut(Demande demandeSaved) {

        // 🔥 IMPORTANT : récupérer depuis la base
        Statut statutInitial = statutRepo.findById(2)
                .orElseThrow(() -> new RuntimeException("Statut initial introuvable"));

        DemandeStatut ds = new DemandeStatut();
        ds.setDemande(demandeSaved);
        ds.setStatut(statutInitial);
        ds.setDate(LocalDate.now());

        demandeStatutRepo.save(ds);
    }

    // SUPPRIMER
    public void delete(Integer id) {
        demande.deleteById(id);
    }
}