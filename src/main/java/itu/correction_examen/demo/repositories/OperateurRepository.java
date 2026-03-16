package itu.correction_examen.demo.repositories;

import itu.correction_examen.demo.entity.Operateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperateurRepository extends JpaRepository<Operateur, Integer> {
}
