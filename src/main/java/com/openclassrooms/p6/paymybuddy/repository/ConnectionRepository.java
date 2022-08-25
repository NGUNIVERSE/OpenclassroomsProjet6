package com.openclassrooms.p6.paymybuddy.repository;

import com.openclassrooms.p6.paymybuddy.model.Connection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectionRepository extends CrudRepository<Connection, Integer> {
}
