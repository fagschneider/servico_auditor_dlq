package com.example.projetoAWS.core.domain.service;

import com.example.projetoAWS.core.domain.model.OrderItem;
import com.example.projetoAWS.core.domain.model.Severity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeverityClassifier {

    public Severity classify(List<OrderItem> items) {

        int total = items.stream()
                .mapToInt(OrderItem::getAmount)
                .sum();

        if (total > 100) {
            return Severity.HIGH;
        }

        if (total >= 50) {
            return Severity.MEDIUM;
        }

        return Severity.LOW;
    }
}