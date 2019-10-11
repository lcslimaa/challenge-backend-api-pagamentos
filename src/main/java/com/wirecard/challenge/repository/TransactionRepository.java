package com.wirecard.challenge.repository;

import com.wirecard.challenge.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
