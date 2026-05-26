package com.example.projetoAWS.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.projetoAWS.application.ports.in.ProcessDlqMessageUseCase;
import com.example.projetoAWS.application.ports.out.SaveAuditErrorPort;
import com.example.projetoAWS.core.domain.model.AuditError;
import com.example.projetoAWS.core.domain.model.OrderEvent;
import com.example.projetoAWS.core.domain.model.Severity;
import com.example.projetoAWS.core.domain.model.Status;
import com.example.projetoAWS.core.domain.service.SeverityClassifier;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProcessDlqMessageService implements ProcessDlqMessageUseCase {

    private final SaveAuditErrorPort saveAuditErrorPort;
    private final SeverityClassifier severityClassifier;
    private final ObjectMapper objectMapper;

    @Value("${aws.sqs.dlq-name}")
    private String queueName;

    @Override
    public void process(String payload) {

        try {

            OrderEvent event = objectMapper.readValue(payload, OrderEvent.class);

            Severity severity = severityClassifier.classify(event.getOrderItems());

            AuditError auditError = AuditError.builder()
                    .errorId(UUID.randomUUID())
                    .queueName(queueName)
                    .payload(payload)
                    .timestamp(Instant.now())
                    .status(Status.PENDING_ANALYSIS)
                    .severity(severity)
                    .build();

            saveAuditErrorPort.save(auditError);

            System.out.println("Mensagem salva com sucesso no banco.");

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao processar payload da DLQ", e);
        }
    }
}