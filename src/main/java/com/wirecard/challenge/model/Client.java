package com.wirecard.challenge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "CLIENT")
@Entity(name = "Client")
public class Client {

    private int id;

    @Id
    @Column(name = "CLIENT_ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
