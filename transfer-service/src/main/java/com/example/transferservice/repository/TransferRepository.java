package com.example.transferservice.repository;

import com.example.transferservice.dto.TransferDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<TransferDto,Long> {
}
