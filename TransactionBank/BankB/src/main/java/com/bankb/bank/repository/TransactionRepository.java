package com.bankb.bank.repository;

import com.bankb.bank.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transactions,Integer> {
}
