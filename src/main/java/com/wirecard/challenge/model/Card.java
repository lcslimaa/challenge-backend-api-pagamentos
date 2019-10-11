package com.wirecard.challenge.model;

import br.com.moip.creditcard.Brands;
import br.com.moip.validators.CreditCard;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.beans.Transient;
import java.util.Date;

@Table(name = "CARD")
@Entity
public class Card {

    private int id;
    private String cardHolderName;
    private String cardNumber;
    private Date cardExpirationDate;
    private int cardCVV;
    private String cardIssuer;
    private boolean isValid;
    private String message;

    @Column(name = "CARD_NUMBER")
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void validateCard() {
        CreditCard creditCard = new CreditCard(getCardNumber());

        if (creditCard.getBrand().equals(Brands.UNKNOWN)) {
            this.message = "Bandeira inválida";
        }
        if (!creditCard.isValid()) {
            this.message = "Cartão inválido";
        }
        this.cardIssuer = String.valueOf(creditCard.getBrand());
    }

    @Id
    @GeneratedValue
    @Column(name = "CARD_ID")
    @JsonIgnore
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "CARD_ISSUER")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public String getCardIssuer() {
        return cardIssuer;
    }

    public void setCardIssuer(String cardIssuer) {
        this.cardIssuer = cardIssuer;
    }

    @Column(name = "CARD_HOLDER_NAME")
    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "EXPIRATION_DATE")
    public Date getCardExpirationDate() {
        return cardExpirationDate;
    }

    public void setCardExpirationDate(Date cardExpirationDate) {
        this.cardExpirationDate = cardExpirationDate;
    }


    @Column(name = "CARD_CVV")
    public int getCardCVV() {
        return cardCVV;
    }

    public void setCardCVV(int cardCVV) {
        this.cardCVV = cardCVV;
    }

    @JsonIgnore
    @Transient
    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    @JsonIgnore
    @Transient
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
