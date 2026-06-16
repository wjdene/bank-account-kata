package com.bank.service;

import com.bank.exception.InsufficientFundsException;
import com.bank.repository.InMemoryAccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceImplTest {

    private AccountServiceImpl service;
    private InMemoryAccountRepository repository;
    @BeforeEach
    void setUp() {
        repository = new InMemoryAccountRepository();
        service = new AccountServiceImpl(repository);
    }

    @Test
    void should_deposit_money() {
        service.deposit(BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(100),repository.getBalance());
    }

    @Test
    void should_withdraw_money() {
        service.deposit(BigDecimal.valueOf(500));
        service.withdraw(BigDecimal.valueOf(200));
        assertEquals( BigDecimal.valueOf(300),repository.getBalance());
    }

    @Test
    void should_throw_exception_when_balance_is_insufficient() {
        assertThrows(InsufficientFundsException.class, () -> service.withdraw(BigDecimal.valueOf(100)));
    }

    @Test
    void should_return_statement() {
        service.deposit(BigDecimal.valueOf(100));
        service.withdraw(BigDecimal.valueOf(50));
        assertEquals(2,service.getStatement().size());
    }
    @Test
    void should_reject_negative_deposit()
    {
        assertThrows(IllegalArgumentException.class, () -> service.deposit(BigDecimal.valueOf(-100)));
    }
}