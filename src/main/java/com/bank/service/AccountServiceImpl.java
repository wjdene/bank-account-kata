package com.bank.service;
import com.bank.exception.InsufficientFundsException;
import com.bank.model.Transaction;
import com.bank.model.TransactionType;
import com.bank.repository.InMemoryAccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final InMemoryAccountRepository repository;

    public AccountServiceImpl(InMemoryAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public void deposit(BigDecimal amount) {
        validateAmount(amount);
        BigDecimal newBalance = repository.getBalance().add(amount);
        repository.setBalance(newBalance);
        repository.getTransactions().add(new Transaction(LocalDateTime.now(),TransactionType.DEPOSIT,amount, newBalance));
    }

    @Override
    public void withdraw(BigDecimal amount) {
        validateAmount(amount);
        if (repository.getBalance().compareTo(amount) < 0) {
            throw new InsufficientFundsException("Insufficient balance");
        }
        BigDecimal newBalance =repository.getBalance().subtract(amount);
        repository.setBalance(newBalance);
        repository.getTransactions().add(new Transaction( LocalDateTime.now(),TransactionType.WITHDRAWAL, amount,newBalance));
    }

    @Override
    public List<Transaction> getStatement() {
        return List.copyOf(repository.getTransactions());
    }

    private void validateAmount(BigDecimal amount) {
        if (amount == null ||amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException( "Amount must be positive");
        }
    }
}