package com.bank.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
/**
 * Records every account operation with the resulting balance.
 */
public record Transaction( LocalDateTime date, TransactionType type, BigDecimal amount, BigDecimal balance) {
}