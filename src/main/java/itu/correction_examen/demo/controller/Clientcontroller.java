package itu.correction_examen.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import itu.correction_examen.demo.entity.Client;
import itu.correction_examen.demo.service.ClientService;



@RestController
@RequestMapping("/api/client") 
@CrossOrigin(origins = "http://localhost:5173") 
public class Clientcontroller {

    @Autowired
    private ClientService service;

    //  LIRE TOUT (GET http://localhost:8080/api/nom-url
    @GetMapping
    public List<Client> getAll() {
        return service.findAll();
    }

    //  LIRE UN SEUL (GET http://localhost:8080/api/nom-url/5)
    @GetMapping("/{id}")
    public Client getById(@PathVariable Integer id) {
        return service.findById(id);
    }
    

    // (POST http://localhost:8080/api/nom-url)
    @PostMapping
    public Client create(@RequestBody Client obj) {
        return service.save(obj);
    }

    //  MODIFIER (PUT http://localhost:8080/api/nom-url/5)
    @PutMapping("/{id}")
    public Client update(@PathVariable Integer id, @RequestBody Client obj) {
        obj.setId(id); 
        return service.save(obj);
    }

    //  SUPPRIMER (DELETE http://localhost:8080/api/nom-url/5)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}



