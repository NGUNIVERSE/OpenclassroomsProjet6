package com.openclassrooms.p6.paymybuddy.service;

import com.openclassrooms.p6.paymybuddy.model.Utilisateur;
import com.openclassrooms.p6.paymybuddy.repository.UtilisateurRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Iterable<Utilisateur> getUtilisateurs() {
        return utilisateurRepository.findAll();
    }
}
