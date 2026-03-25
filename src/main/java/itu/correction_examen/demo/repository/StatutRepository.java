package itu.correction_examen.demo.repository;
import itu.correction_examen.demo.entity.Statut;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface StatutRepository extends JpaRepository<Statut, Integer> {
    
}
