package com.example.authservice.repository;

import com.example.authservice.model.CommunicateInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunicateInformationRepository extends JpaRepository<CommunicateInformation,Long> {
    CommunicateInformation findCommunicateInformationById(long id);
}
