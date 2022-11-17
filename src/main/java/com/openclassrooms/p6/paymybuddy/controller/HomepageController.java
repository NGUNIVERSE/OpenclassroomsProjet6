package com.openclassrooms.p6.paymybuddy.controller;

import com.openclassrooms.p6.paymybuddy.dto.UtilisateurDto;
import com.openclassrooms.p6.paymybuddy.model.Utilisateur;
import com.openclassrooms.p6.paymybuddy.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.Optional;

@Controller
public class HomepageController {

    @Autowired
    private UtilisateurService utilisateurService;

    @RequestMapping("/homepage")
    @RolesAllowed("ROLE_USER")
    public ModelAndView render(Authentication authentication) {

        ModelAndView modelAndView = new ModelAndView("homepage");
        Optional<Utilisateur> utilisateurOptional = utilisateurService.getUtilisateurByEmail(authentication.getName());
        modelAndView.addObject("utilisateur", utilisateurOptional.map(UtilisateurDto::fromEntity).orElse(null));
        modelAndView.addObject("breadcrumb", "");
        return modelAndView;
    }

}
