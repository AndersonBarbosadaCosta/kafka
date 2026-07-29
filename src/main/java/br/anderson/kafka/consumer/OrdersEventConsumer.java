package br.anderson.kafka.consumer;

import br.anderson.kafka.exceptions.ExternalServiceException;
import br.anderson.kafka.exceptions.InvalidOrderException;
import br.anderson.kafka.model.OrderCreateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrdersEventConsumer {

    private final static Logger logger = LoggerFactory.getLogger(OrdersEventConsumer.class);

    @KafkaListener(topics = "orders", groupId = "payment-service")
    public void consume(OrderCreateEvent event) {

        logger.info(String.format("Order processing: eventID=%s, orderId=%s", event.eventId(), event.orderId()));

        if (event.totalAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidOrderException("Order amount must be greater than 0 ");
        }
        if ("ORD-FAIL".equals(event.orderId())) {
            throw new ExternalServiceException("Payment Service Unavailable");
        }

        logger.info(String.format("Order processing successfully: orderId=%s", event.orderId()));

    }
}
