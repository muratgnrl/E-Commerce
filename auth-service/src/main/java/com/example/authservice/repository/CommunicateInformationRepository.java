package com.example.authservice.repository;

import com.example.authservice.entity.CommunicateInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunicateInformationRepository  extends JpaRepository<CommunicateInformation,Long> {
    CommunicateInformation findByCommunicateInformationId(long communicateInformationId);

    void deleteByCommunicateInformationId(long communicateInformationId);
}
