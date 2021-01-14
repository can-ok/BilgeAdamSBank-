package com.banka.demo.repository;

import com.banka.demo.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transactions,Integer> {
}
