package itu.correction_examen.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import itu.correction_examen.demo.entity.DemandeStatut;

@Repository
public interface DemandeStatutRepository extends JpaRepository<DemandeStatut, Integer> {
}