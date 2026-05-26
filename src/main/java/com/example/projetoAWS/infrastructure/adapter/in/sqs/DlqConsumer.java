package com.example.projetoAWS.infrastructure.adapter.in.sqs;

import com.example.projetoAWS.application.ports.in.ProcessDlqMessageUseCase;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DlqConsumer {

    private final ProcessDlqMessageUseCase processDlqMessageUseCase;

    @SqsListener("${aws.sqs.dlq-name}")
    public void consume(String payload) {

        System.out.println("Mensagem recebida da DLQ:");
        System.out.println(payload);

        processDlqMessageUseCase.process(payload);
    }
}