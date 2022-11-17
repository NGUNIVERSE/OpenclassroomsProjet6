package com.openclassrooms.p6.paymybuddy.controller;

import com.openclassrooms.p6.paymybuddy.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;

@Controller
public class TransferController {

    @Autowired
    private UtilisateurService utilisateurService;

    @RequestMapping("/homepage/transfer")
    @RolesAllowed("ROLE_USER")
    public ModelAndView getUser(Authentication authentication) {

        ModelAndView modelAndView = new ModelAndView("transfer");
        modelAndView.addObject("authentication", authentication);
        modelAndView.addObject("utilisateur", utilisateurService.getUtilisateurByEmail(authentication.getName()).orElseThrow()); //charge l'utilisateur depuis la BDD
        modelAndView.addObject("breadcrumb", "Transfer");
        return modelAndView;
    }

}
