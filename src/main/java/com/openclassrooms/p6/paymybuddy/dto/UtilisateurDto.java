package com.openclassrooms.p6.paymybuddy.dto;

import com.openclassrooms.p6.paymybuddy.model.Utilisateur;
import lombok.Data;


@Data
public class UtilisateurDto {

    private String nom;
    private String prenom;
    private String email;
    private Long solde;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur) {

        UtilisateurDto utilisateurDto = new UtilisateurDto();
        utilisateurDto.email = utilisateur.getEmail();
        utilisateurDto.nom = utilisateur.getNom();
        utilisateurDto.prenom = utilisateur.getPrenom();
        utilisateurDto.solde = utilisateur.getSolde();

        return utilisateurDto;
    }
}
