package com.example.payment.repository;

import com.example.payment.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Transaction,Integer> {
}
