package com.openclassrooms.p6.paymybuddy.controller;

import com.openclassrooms.p6.paymybuddy.model.MyUserDetails;
import com.openclassrooms.p6.paymybuddy.model.Utilisateur;
import com.openclassrooms.p6.paymybuddy.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//@RestController
@Controller

public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/utilisateurs")
    public Iterable<Utilisateur> getUtilisateurs() {
        return utilisateurService.getUtilisateurs();

    }

    @GetMapping("/inscription")
    public String inscription() {
        return "inscription";
    }

    @GetMapping("/registration")
    public String registration(Model model, Authentication authentication) {

        if ((authentication != null) && (authentication.isAuthenticated())) {
            return "redirect:/homepage";
        } else {
            model.addAttribute("utilisateur", new Utilisateur());
            return "registration";
        }
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("utilisateur") Utilisateur utilisateur) {
        // ajouter ici le new utilisateur (faire un DTO pour l'utilisateur) avec le role et encrypter le mot de passe.
        utilisateur.setRole("ROLE_USER");
        utilisateurService.save(utilisateur);

        MyUserDetails userDetails = new MyUserDetails(utilisateur);

        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
        return "redirect:/homepage";
    }
}