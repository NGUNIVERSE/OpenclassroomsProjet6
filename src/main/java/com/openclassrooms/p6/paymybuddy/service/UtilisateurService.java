package com.openclassrooms.p6.paymybuddy.service;

import com.openclassrooms.p6.paymybuddy.model.Utilisateur;
import com.openclassrooms.p6.paymybuddy.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Iterable<Utilisateur> getUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public void save(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }

    public Optional<Utilisateur> getUtilisateurByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }

    public void addConnection(String emailSender, String emailRecipient) {
        Utilisateur sender = utilisateurRepository.findByEmail(emailSender).orElseThrow();
        Utilisateur recipient = utilisateurRepository.findByEmail(emailRecipient).orElseThrow();

        sender.getConnections().add(recipient);

        utilisateurRepository.save(sender);

    }
}
