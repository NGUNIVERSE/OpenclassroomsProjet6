package com.openclassrooms.p6.paymybuddy.repository;

import com.openclassrooms.p6.paymybuddy.model.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {


}
