package com.openclassrooms.p6.paymybuddy.controller;

import com.openclassrooms.p6.paymybuddy.dto.SearchUserDto;
import com.openclassrooms.p6.paymybuddy.model.Utilisateur;
import com.openclassrooms.p6.paymybuddy.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class ConnectionController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/homepage/connection")
    @RolesAllowed("ROLE_USER")
    public ModelAndView getUser(Authentication authentication) {

        ModelAndView modelAndView = new ModelAndView("connection");
        modelAndView.addObject("authentication", authentication);
        modelAndView.addObject("searchUser", new SearchUserDto());
        modelAndView.addObject("breadcrumb", "Tranfer");
        return modelAndView;
    }

    @PostMapping(value = "/homepage/connection", params = "action=search")
    public ModelAndView searchUser(@ModelAttribute("searchUser") @Valid SearchUserDto searchUser, Authentication authentication, BindingResult bindingResult) {
        Optional<Utilisateur> utilisateurSearch = utilisateurService.getUtilisateurByEmail(searchUser.getEmail());

        if (utilisateurSearch.isPresent() && (!utilisateurSearch.get().getEmail().equals(authentication.getName()))) {

            searchUser.setName(utilisateurSearch.get().getNom());

        } else {
            searchUser.setName(null); // reinitialise la valeur du name de la vue en cas de deuxième recherche
        }

        bindingResult.addError(new FieldError("searchUser", "email", "Vous ne pouvez pas vous ajouter"));
        ModelAndView modelAndView = new ModelAndView("connection");
        modelAndView.addObject("authentication", authentication);
        modelAndView.addObject("searchUser", searchUser);
        modelAndView.addObject("breadcrumb", "Transfer");
        return modelAndView;

    }

    @PostMapping(value = "/homepage/connection", params = "action=add")
    public String addUser(@ModelAttribute("searchUser") SearchUserDto searchUser, Authentication authentication) {

        utilisateurService.addConnection(authentication.getName(), searchUser.getEmail());

        return "redirect:/homepage/transfer";

    }


}