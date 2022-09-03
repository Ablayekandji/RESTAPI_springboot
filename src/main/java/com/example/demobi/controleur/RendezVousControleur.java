package com.example.demobi.controleur;

import com.example.demobi.modele.RendezVous;
import com.example.demobi.service.ServiceRendezVous;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rv")
public class RendezVousControleur {
    private final ServiceRendezVous serviceRendezVous;

    public RendezVousControleur(ServiceRendezVous serviceRendezVous) {
        this.serviceRendezVous = serviceRendezVous;
    }
    @GetMapping("/tousrv")
    public ResponseEntity<List<RendezVous>> getAllrvs(){
        List<RendezVous> list=this.serviceRendezVous.gettAllrvs();
        return new ResponseEntity<List<RendezVous>>(list, HttpStatus.OK);
    }

    @GetMapping("/chercher/{id}")
    public ResponseEntity<RendezVous> chercherRVparid(@PathVariable("id") Long id){
        RendezVous rendezVous=this.serviceRendezVous.trouverRVbyID(id);
        return new ResponseEntity<RendezVous>(rendezVous,HttpStatus.OK);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<RendezVous> supprimerRVparId(@PathVariable("id") Long id){
        this.serviceRendezVous.supprimerrv(id);
        return new ResponseEntity<RendezVous>(HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<RendezVous> ajouterRV(@RequestBody RendezVous rendezVous){
        RendezVous rendezVous1 =this.serviceRendezVous.ajouterRV(rendezVous);
        return new ResponseEntity<RendezVous>(rendezVous1,HttpStatus.OK);
    }

    @PutMapping("/miseajour")
    public ResponseEntity<RendezVous> miseajourRV(@RequestBody RendezVous rendezVous){
        RendezVous rendezVous1 =this.serviceRendezVous.miseajourRV(rendezVous);
        return new ResponseEntity<RendezVous>(rendezVous1,HttpStatus.OK);
    }
}
