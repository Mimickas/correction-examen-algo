package itu.correction_examen.demo.repositories;

import itu.correction_examen.demo.entity.Correcteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorrecteurRepository extends JpaRepository<Correcteur, Integer> {
}
