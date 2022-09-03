package com.example.demobi.service;

import com.example.demobi.exception.RvNotFoundException;
import com.example.demobi.modele.RendezVous;
import com.example.demobi.repo.RendezVousRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceRendezVous {
    private final RendezVousRepo rendezVousRepo;

    @Autowired
    public ServiceRendezVous(RendezVousRepo rendezVousRepo) {
        this.rendezVousRepo = rendezVousRepo;
    }

    public RendezVous ajouterRV(RendezVous rv){
        rv.setCodeRV(UUID.randomUUID().toString());
        return rendezVousRepo.save(rv);
    }

    public List<RendezVous> gettAllrvs(){
        return rendezVousRepo.findAll();
    }

    public void supprimerrv(Long id){
        rendezVousRepo.deleteById(id);
    }
    public RendezVous trouverRVbyID(Long id){
        return rendezVousRepo.findById(id).orElseThrow(()->new RvNotFoundException("Rv avec id "+id+ " non trouvé"));

    }

    public RendezVous miseajourRV(RendezVous rendezVous){
        return rendezVousRepo.save(rendezVous);
    }
}
