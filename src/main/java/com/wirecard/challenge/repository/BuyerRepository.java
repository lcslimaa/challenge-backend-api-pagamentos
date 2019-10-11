package com.wirecard.challenge.repository;

import com.wirecard.challenge.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BuyerRepository extends JpaRepository<Buyer, Integer> {

    public static final String find_by_cpf = "SELECT * FROM BUYER WHERE BUYER_CPF = ?1";

    @Query(value = find_by_cpf, nativeQuery = true)
    public Optional<Buyer> findByCpf(String cpf);

}
