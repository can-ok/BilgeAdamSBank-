package com.bankb.bank.repository;

import com.bankb.bank.entity.BankB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<BankB,Integer> {
}
