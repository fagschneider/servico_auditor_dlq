package com.example.projetoAWS.core.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEvent {

    private String zipCode;
    private Integer customerId;
    private List<OrderItem> orderItems;
    private String origin;
    private Instant occurredAt;
}