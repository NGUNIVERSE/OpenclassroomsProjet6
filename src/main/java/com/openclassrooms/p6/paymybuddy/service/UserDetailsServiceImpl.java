package com.openclassrooms.p6.paymybuddy.service;

import com.openclassrooms.p6.paymybuddy.dto.UserDetailsDto;
import com.openclassrooms.p6.paymybuddy.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return utilisateurRepository.findByEmail(email)
                .map(UserDetailsDto::new)
                .orElseThrow(() -> new UsernameNotFoundException("Not found: " + email));
    }
}

