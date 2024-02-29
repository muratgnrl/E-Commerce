package com.example.paymentservice.repository;

import com.example.paymentservice.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Transaction,Long> {
}
