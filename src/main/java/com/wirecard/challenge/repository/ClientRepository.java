package com.wirecard.challenge.repository;

import com.wirecard.challenge.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository <Client, Integer> {
}
