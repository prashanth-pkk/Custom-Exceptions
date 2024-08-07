package com.custom.exceptions.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Acc_holder_name;
    private String Acc_number;
    private double balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcc_holder_name() {
        return Acc_holder_name;
    }

    public void setAcc_holder_name(String acc_holder_name) {
        Acc_holder_name = acc_holder_name;
    }

    public String getAcc_number() {
        return Acc_number;
    }

    public void setAcc_number(String acc_number) {
        Acc_number = acc_number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
