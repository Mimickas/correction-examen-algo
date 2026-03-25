
package itu.correction_examen.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import itu.correction_examen.demo.entity.Demande;
import itu.correction_examen.demo.service.DemandeService;
 

@RestController
@RequestMapping("/api/Demande") 
@CrossOrigin(origins = "http://localhost:5173") 
public class Demandecontroller {

    @Autowired
    private DemandeService demande;

    //  LIRE TOUT (GET http://localhost:8080/api/nom-url)
    @GetMapping
    public List<Demande> getAll() {
        return demande.findAll();
    }

    //  LIRE UN SEUL (GET http://localhost:8080/api/nom-url/5)
    @GetMapping("/{id}")
    public Demande getById(@PathVariable Integer id) {
        return demande.findById(id);
    }

    //  CRÉER (POST http://localhost:8080/api/nom-url)
    @PostMapping
    public Demande create(@RequestBody Demande obj) {
        return demande.save(obj);
    }

    //  MODIFIER (PUT http://localhost:8080/api/nom-url/5)
    @PutMapping("/{id}")
    public Demande update(@PathVariable Integer id, @RequestBody Demande obj) {
        obj.setId(id); 
        return demande.save(obj);
    }

    //  SUPPRIMER (DELETE http://localhost:8080/api/nom-url/5)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        demande.delete(id);
    }
}