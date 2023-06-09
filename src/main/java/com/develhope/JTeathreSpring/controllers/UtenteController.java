package com.develhope.JTeathreSpring.controllers;

import com.develhope.JTeathreSpring.entities.Ticket;
import com.develhope.JTeathreSpring.entities.Utente;
import com.develhope.JTeathreSpring.entities.Venue;
import com.develhope.JTeathreSpring.repositories.UtenteRepository;
import com.develhope.JTeathreSpring.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utente")
public class UtenteController {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private UtenteService utenteService;

    @PostMapping("/register")
    public void createUser(@RequestBody Utente utente) {
        utenteRepository.saveAndFlush(utente);
    }

    @GetMapping("/get/{id}")
    public Utente getUtente(@PathVariable Long id_utente) {
        Optional<Utente> optionalUtente = utenteRepository.findById(id_utente);
        if (optionalUtente.isEmpty()) throw new IllegalArgumentException("l'utente non esiste!");
        return optionalUtente.get();
    }

    @GetMapping("/getall")
    public List<Utente> getAllLocations() {
        return utenteRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id) {
        utenteRepository.deleteById(id);
    }

    @DeleteMapping("/deleteall")
    public void deleteAll() {
        utenteRepository.deleteAll();
    }


    @PostMapping("/buyticket")
    public double buyTicket(@RequestParam long id_user, @RequestParam  long id_seat, @RequestParam long id_show) {
        return utenteService.buyTicket(id_user, id_seat, id_show);
    }
}
