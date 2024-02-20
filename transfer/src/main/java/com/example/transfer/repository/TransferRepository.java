package com.example.transfer.repository;

import com.example.transfer.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer,Integer> {
}
