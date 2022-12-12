package com.openclassrooms.p6.paymybuddy.service;

import com.openclassrooms.p6.paymybuddy.dto.TransactionDto;
import com.openclassrooms.p6.paymybuddy.model.Transaction;
import com.openclassrooms.p6.paymybuddy.model.Utilisateur;
import com.openclassrooms.p6.paymybuddy.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UtilisateurService utilisateurService;

    public void pay(TransactionDto transactionDto, Authentication authentication) {
        Utilisateur sender = utilisateurService.getUtilisateurByEmail(authentication.getName()).orElseThrow();
        Utilisateur recipient = utilisateurService.getUtilisateurById(transactionDto.getRecipientid()).orElseThrow();

        if (transactionDto.getAmount() <= sender.getSolde()) {
            Transaction transaction = new Transaction();
            transaction.setSender(sender);
            transaction.setRecipient(recipient);
            transaction.setAmount(transactionDto.getAmount());
            transaction.setDescription(transactionDto.getDescription());

            transactionRepository.save(transaction);

            sender.setSolde(sender.getSolde() - transactionDto.getAmount());
            sender.getTransfers().add(transaction);
            recipient.setSolde(recipient.getSolde() + transactionDto.getAmount());
            recipient.getCredits().add(transaction);

            utilisateurService.save(sender);
            utilisateurService.save(recipient);


        }

    }

}
