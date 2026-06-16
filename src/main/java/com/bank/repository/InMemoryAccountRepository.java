package com.bank.repository;

import com.bank.model.Transaction;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
/**
 * In-memory repository used for the kata.
 * No persistence is required by the specification.
 */

@Repository
public class InMemoryAccountRepository {

    private BigDecimal balance = BigDecimal.ZERO;

    private final List<Transaction> transactions = new ArrayList<>();

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}