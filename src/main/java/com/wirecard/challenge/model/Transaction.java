package com.wirecard.challenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wirecard.challenge.model.type.PaymentStatus;

import javax.persistence.*;

@Table(name = "TRANSACTION")
@Entity
public class Transaction {

    private int transactionId;
    private boolean successful;
    private String message;
    private Client client;
    private Buyer buyer;
    private Payment payment;

    @Id
    @GeneratedValue
    @Column(name = "TRANSACTION_ID")
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    @Column(name = "TRANSACTION_SUCCESFUL")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    @Column(name = "TRANSACTION_MESSAGE")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clientId", referencedColumnName = "CLIENT_ID")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buyerId", referencedColumnName = "BUYER_ID")
    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paymentId", referencedColumnName = "PAYMENT_ID")
    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus){
        payment.setPaymentStatus(paymentStatus);
    }

}

