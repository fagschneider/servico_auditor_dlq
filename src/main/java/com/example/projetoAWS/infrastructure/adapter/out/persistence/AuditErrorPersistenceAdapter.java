package com.example.projetoAWS.infrastructure.adapter.out.persistence;

import com.example.projetoAWS.application.ports.out.SaveAuditErrorPort;
import com.example.projetoAWS.core.domain.model.AuditError;
import com.example.projetoAWS.infrastructure.mapper.AuditErrorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuditErrorPersistenceAdapter implements SaveAuditErrorPort {

    private final AuditErrorRepository repository;
    private final AuditErrorMapper mapper;

    @Override
    public void save(AuditError auditError) {

        AuditErrorEntity entity = mapper.toEntity(auditError);

        repository.save(entity);
    }
}