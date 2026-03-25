package itu.correction_examen.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itu.correction_examen.demo.entity.Client;
import itu.correction_examen.demo.repository.ClientRepository;



@Service
public class ClientService {

    @Autowired
    private ClientRepository client;

    //  RÉCUPÉRER TOUT
    public List<Client> findAll() {
        return client.findAll();
    }

    //  RÉCUPÉRER UN SEUL (par son ID)
    public Client findById(Integer id) {
        // .orElse(null) évite que le programme plante si l'ID n'existe pas
        return client.findById(id).orElse(null);
    }

    //  ENREGISTRER / MODIFIER
    public Client save(Client obj) {
        return client.save(obj);
    }

    //  SUPPRIMER
    public void delete(Integer id) {
        client.deleteById(id);
    }
    
}

