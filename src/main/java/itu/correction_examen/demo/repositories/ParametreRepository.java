package itu.correction_examen.demo.repositories;

import itu.correction_examen.demo.entity.Matiere;
import itu.correction_examen.demo.entity.Parametre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParametreRepository extends JpaRepository<Parametre, Long> {
    public List<Parametre> findByMatiere(Matiere matiere);
}
