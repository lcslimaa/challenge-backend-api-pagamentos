package com.wirecard.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wirecard.challenge.model.type.PaymentMethod;
import com.wirecard.challenge.model.type.PaymentStatus;
import com.wirecard.challenge.resource.PaymentMethodJpaConverter;

import javax.persistence.*;

@Table(name = "payment")
@Entity
public class Payment {

    private int paymentId;
    private double amount;
    private Card card;
    private Billet billet;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;

    @Id
    @GeneratedValue
    @Column(name = "PAYMENT_ID")
    @JsonIgnore
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    @Column(name = "PAYMENT_AMOUNT")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Column(name = "PAYMENT_METHOD")
    @Convert(converter = PaymentMethodJpaConverter.class)
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Column(name = "PAYMENT_STATUS")
    public PaymentStatus getPaymentStatus(){
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus){
        this.paymentStatus = paymentStatus;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cardId", referencedColumnName = "CARD_ID")
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billetId", referencedColumnName = "BILLET_ID")
    public Billet getBillet() {
        return billet;
    }

    public void setBillet(Billet billet) {
        this.billet = billet;
    }

}
