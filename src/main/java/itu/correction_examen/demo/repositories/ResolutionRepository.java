package itu.correction_examen.demo.repositories;

import itu.correction_examen.demo.entity.Resolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResolutionRepository extends JpaRepository<Resolution, Long> {
}
