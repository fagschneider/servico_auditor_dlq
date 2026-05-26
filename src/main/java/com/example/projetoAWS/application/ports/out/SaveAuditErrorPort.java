package com.example.projetoAWS.application.ports.out;

import com.example.projetoAWS.core.domain.model.AuditError;

public interface SaveAuditErrorPort {

    void save(AuditError auditError);
}