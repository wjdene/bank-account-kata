package com.bank.controller;

import com.bank.dto.AmountRequest;
import com.bank.model.Transaction;
import com.bank.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/deposit")
    public void deposit( @RequestBody AmountRequest request) {
        accountService.deposit(request.amount());
    }

    @PostMapping("/withdraw")
    public void withdraw( @RequestBody @Valid AmountRequest request) {
        accountService.withdraw(request.amount());
    }

    @GetMapping("/statement")
    public List<Transaction> statement() {
        return accountService.getStatement();
    }


    @GetMapping(value = "/statement/print", produces = MediaType.TEXT_PLAIN_VALUE)
    public String printStatement() {
        return accountService.printStatement();
    }
}