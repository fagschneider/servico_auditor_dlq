package com.example.projetoAWS.infrastructure.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuditErrorRepository extends JpaRepository<AuditErrorEntity, UUID> {
}