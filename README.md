# 🏦 Bank Account Kata

## 📋 Overview

This project is an implementation of the **Bank Account Kata** proposed as a technical assessment.

The application exposes a simple REST API allowing a bank client to:

* 💰 Deposit money into an account
* 💸 Withdraw money from an account
* 📄 View account operation history
* 📊 Print an account statement including operation date, type, amount and balance

The solution intentionally focuses on business logic and testability, following the requirements of the exercise:

* ✅ No database
* ✅ No persistence layer
* ✅ No user interface
* ✅ In-memory storage only

---

## 🚀 Technical Stack

| Technology  | Version |
| ----------- | ------- |
| Java        | 17      |
| Spring Boot | 3       |
| Maven       | Latest  |
| JUnit       | 5       |

---

## 🏗️ Architecture

The application follows a simple layered architecture:

```text
com.bank
├── controller
├── service
├── repository
├── model
├── dto
├── exception
└── BankAccountKataApplication
```

### Responsibilities

| Layer      | Responsibility                                     |
|------------|----------------------------------------------------|
| Controller | Exposes REST endpoints                             |
| Service    | Contains business rules and account operations     |
| Repository | Stores account data in memory                      |
| Model      | Contains domain objects                            |
| DTO        | Request/response objects exchanged through the API |
| Exception  | Contains business exceptions                       |

---

## 📌 Business Rules

### Deposit

A client can deposit a positive amount into the account.

### Withdrawal

A client can withdraw money if sufficient funds are available.

An exception is thrown when attempting to withdraw more than the current balance.

### Statement

Each operation is recorded with:

* Date
* Operation type
* Amount
* Resulting balance

---

## 🔗 API Endpoints

### Deposit

```http
POST /api/account/deposit
```

Request:

```json
{
  "amount": 1000
}
```

### Withdraw

```http
POST /api/account/withdraw
```

Request:

```json
{
  "amount": 200
}
```

### Statement

```http
GET /api/account/statement
```

Example Response:

```json
[
  {
    "date": "2026-06-16T10:00:00",
    "type": "DEPOSIT",
    "amount": 1000,
    "balance": 1000
  },
  {
    "date": "2026-06-16T11:00:00",
    "type": "WITHDRAWAL",
    "amount": 200,
    "balance": 800
  }
]
```

---

## ▶️ Running the Application

```bash
mvn spring-boot:run
```

Application starts on:

```text
http://localhost:8080
```

---

## 🧪 Running Unit Tests

Execute all tests:

```bash
mvn test
```

Unit tests are located under:

```text
src/test/java
```

Main test class:

```text
AccountServiceImplTest
```

---

## ✅ User Stories Coverage

### US1 - Deposit Money

Covered by:

* ✔ should_deposit_money()

### US2 - Withdraw Money

Covered by:

* ✔ should_withdraw_money()
* ✔ should_throw_exception_when_balance_is_insufficient()

### US3 - Account Statement

Covered by:

* ✔ should_return_statement()

### Additional Validation

Covered by:

* ✔ should_reject_negative_amount()

---


## 👩‍💻 Author

**Wijdene Ben Youssef**

Full Stack Java / Angular Developer

Experienced in designing and developing web applications using Java, Spring Boot, Angular and modern software engineering best practices.
