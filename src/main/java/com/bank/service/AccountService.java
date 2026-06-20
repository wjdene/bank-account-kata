package com.bank.service;

import com.bank.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {

    void deposit(BigDecimal amount);

    void withdraw(BigDecimal amount);

    List<Transaction> getStatement();

    String printStatement();

}