package com.wirecard.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Table(name = "BILLET")
@Entity
public class Billet {

    private int billetId;
    private String billetNumber;

    public Billet(){
    }

    public Billet(double amount) {
        this.billetNumber = generateBilletNumber(amount);
    }

    private String generateBilletNumber(double amount) {
        String amountString = String.format("%.2f", amount).replace(".", "").replace(",", "");
        for (int i = amountString.length(); i <= 10; i++) {
            amountString = "0" + amountString;
        }

        return "35573.68110 13455.820300 91223.161238 6 9" + amountString;
    }

    @Id
    @GeneratedValue
    @Column(name = "BILLET_ID")
    @JsonIgnore
    public int getBilletId() {
        return billetId;
    }

    public void setBilletId(int boletoId) {
        this.billetId = boletoId;
    }

    @Column(name = "BILLET_NUMBER")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public String getBilletNumber() {
        return billetNumber;
    }

    public void setBilletNumber(String billetNumber) {
        this.billetNumber = billetNumber;
    }


}
