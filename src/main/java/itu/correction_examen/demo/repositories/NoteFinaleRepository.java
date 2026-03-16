package itu.correction_examen.demo.repositories;

import itu.correction_examen.demo.entity.NoteFinale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteFinaleRepository extends JpaRepository<NoteFinale, Long> {
}
