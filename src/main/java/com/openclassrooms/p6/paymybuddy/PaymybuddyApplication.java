package com.openclassrooms.p6.paymybuddy;

import com.openclassrooms.p6.paymybuddy.model.Utilisateur;
import com.openclassrooms.p6.paymybuddy.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PaymybuddyApplication implements CommandLineRunner {
    @Autowired
    private UtilisateurService utilisateurService;

    public static void main(String[] args) {
        SpringApplication.run(PaymybuddyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Iterable<Utilisateur> utilisateurs = utilisateurService.getUtilisateurs();
        utilisateurs.forEach(utilisateur -> System.out.println(utilisateur.getNom() + " " + utilisateur.getEmail()));
    }

}
