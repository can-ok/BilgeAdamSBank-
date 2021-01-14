package com.banka.demo.repository;

import com.banka.demo.entity.BankA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<BankA,Integer> {
}
