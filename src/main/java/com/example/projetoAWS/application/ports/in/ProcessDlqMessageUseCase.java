package com.example.projetoAWS.application.ports.in;

public interface ProcessDlqMessageUseCase {

    void process(String payload);
}