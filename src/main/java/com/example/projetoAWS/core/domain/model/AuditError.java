package com.example.projetoAWS.core.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditError {

    private UUID errorId;
    private String queueName;
    private String payload;
    private Instant timestamp;
    private Status status;
    private Severity severity;
}