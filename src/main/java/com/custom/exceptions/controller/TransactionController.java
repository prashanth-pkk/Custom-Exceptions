package com.custom.exceptions.controller;

import com.custom.exceptions.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionController {
    @Autowired
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
}
