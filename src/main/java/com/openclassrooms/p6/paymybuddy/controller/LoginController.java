package com.openclassrooms.p6.paymybuddy.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Authentication authentication) {

        if ((authentication != null) && (authentication.isAuthenticated())) {
            return "redirect:/homepage";
        }

        return "login";
    } //redirect : ...

    @RequestMapping("/homepage") // tranfercontroller
    @RolesAllowed("ROLE_USER")
    public ModelAndView getUser(Authentication authentication) {

        ModelAndView modelAndView = new ModelAndView("homepage");
        modelAndView.addObject("authentication", authentication);
        modelAndView.addObject("breadcrumb", "Transfer");
        return modelAndView;
    }

}
