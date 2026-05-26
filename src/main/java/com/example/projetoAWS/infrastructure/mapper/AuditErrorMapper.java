package com.example.projetoAWS.infrastructure.mapper;

import com.example.projetoAWS.core.domain.model.AuditError;
import com.example.projetoAWS.infrastructure.adapter.out.persistence.AuditErrorEntity;
import org.springframework.stereotype.Component;

@Component
public class AuditErrorMapper {

    public AuditErrorEntity toEntity(AuditError auditError) {

        return AuditErrorEntity.builder()
                .errorId(auditError.getErrorId())
                .queueName(auditError.getQueueName())
                .payload(auditError.getPayload())
                .timestamp(auditError.getTimestamp())
                .status(auditError.getStatus())
                .severity(auditError.getSeverity())
                .build();
    }
}