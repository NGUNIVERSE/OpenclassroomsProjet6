package com.openclassrooms.p6.paymybuddy.repository;

import com.openclassrooms.p6.paymybuddy.model.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByEmail(String email);

    Optional<Utilisateur> findById(int id);
}

