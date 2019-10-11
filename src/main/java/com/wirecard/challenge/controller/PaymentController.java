package com.wirecard.challenge.controller;

import com.wirecard.challenge.model.Billet;
import com.wirecard.challenge.model.type.PaymentMethod;
import com.wirecard.challenge.model.type.PaymentStatus;
import com.wirecard.challenge.model.Transaction;
import com.wirecard.challenge.repository.BuyerRepository;
import com.wirecard.challenge.repository.ClientRepository;
import com.wirecard.challenge.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BuyerRepository buyerRepository;

    @PostMapping(value = "/payments")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Transaction createPayment(@RequestBody Transaction transaction) {

        clientRepository.findById(transaction.getClient().getId()).map(client -> {
            transaction.setClient(client);
            return client;
        });

        if (!transaction.getBuyer().getCpf().isEmpty()) {
            buyerRepository.findByCpf(transaction.getBuyer().getCpf()).map(buyer -> {
                buyer.setName(transaction.getBuyer().getName());
                buyer.setEmail(transaction.getBuyer().getEmail());
                transaction.setBuyer(buyer);

                return buyer;
            });
        }

        if (transaction.getPayment().getPaymentMethod().equals(PaymentMethod.BILLET)) {
            transaction.getPayment().setBillet(new Billet(transaction.getPayment().getAmount()));
            transaction.getPayment().setCard(null);
        } else if (transaction.getPayment().getPaymentMethod().equals(PaymentMethod.CREDIT_CARD)) {
            transaction.getPayment().getCard().validateCard();

            if (transaction.getPayment().getCard().isValid() == false) {
                transaction.setSuccessful(transaction.getPayment().getCard().isValid());
                transaction.setMessage(transaction.getPayment().getCard().getMessage());
            }
        }

        transaction.setMessage(PaymentStatus.APPROVED.getDescription());
        transaction.setSuccessful(true);
        transaction.setPaymentStatus(PaymentStatus.APPROVED);
        return transactionRepository.save(transaction);
    }

    @GetMapping(value = "/payments")
    public List<Transaction> getAllPayments() {
        return transactionRepository.findAll();
    }

    @GetMapping(value = "/payments/{paymentId}")
    public Transaction getPayment(@PathVariable int paymentId) {
        return transactionRepository.findById(paymentId).orElseThrow(
                () -> new ResourceNotFoundException("Transaction [paymentId=" + paymentId + "] can't be found"));
    }

}
