package br.anderson.kafka.consumer;

import br.anderson.kafka.model.OrderCreateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumer {

    private final static Logger logger = LoggerFactory.getLogger(PaymentConsumer.class);
    @KafkaListener(topics = "orders", groupId = "payment-service")
    public void consume(OrderCreateEvent event) {

        logger.info("Consumer {}",event.eventId());
    }
}
