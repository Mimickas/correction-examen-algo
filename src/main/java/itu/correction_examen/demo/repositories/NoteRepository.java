package itu.correction_examen.demo.repositories;

import itu.correction_examen.demo.entity.Etudiant;
import itu.correction_examen.demo.entity.Matiere;
import itu.correction_examen.demo.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {
    public List<Note> findAllByEtudiantAndMatiere(Etudiant etudiant, Matiere matiere);
}
