package br.anderson.kafka.model;

import java.math.BigDecimal;
import java.time.Instant;

public record OrderCreateEvent(String eventId, String orderId, String customerId, BigDecimal totalAmount, Instant occurredAt) {
}
