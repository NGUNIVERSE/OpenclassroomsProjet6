package com.openclassrooms.p6.paymybuddy.controller;

import com.openclassrooms.p6.paymybuddy.dto.TransactionDto;
import com.openclassrooms.p6.paymybuddy.service.TransactionService;
import com.openclassrooms.p6.paymybuddy.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;

@Controller
public class TransferController {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private TransactionService transactionService;

    @RequestMapping("/homepage/transfer")
    @RolesAllowed("ROLE_USER")
    public ModelAndView getUser(Authentication authentication) {


        ModelAndView modelAndView = new ModelAndView("transfer");
        modelAndView.addObject("authentication", authentication);
        modelAndView.addObject("transactionDto", new TransactionDto());
        modelAndView.addObject("utilisateur", utilisateurService.getUtilisateurByEmail(authentication.getName()).orElseThrow()); //charge l'utilisateur depuis la BDD
        modelAndView.addObject("breadcrumb", "Transfer");
        return modelAndView;
    }

    @PostMapping(value = "/homepage/transfer", params = "action=pay")
    public String payUser(@ModelAttribute("transactionDto") TransactionDto transactionDto, Authentication authentication) {


        transactionService.pay(transactionDto, authentication);


        return "redirect:/homepage/transfer";

    }

}
