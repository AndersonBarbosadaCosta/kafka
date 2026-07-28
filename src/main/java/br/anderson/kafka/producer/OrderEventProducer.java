package br.anderson.kafka.producer;


import br.anderson.kafka.model.OrderCreateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderEventProducer {
    private final KafkaTemplate<String, OrderCreateEvent> kafkaTemplate;
    private final static Logger logger = LoggerFactory.getLogger(OrderEventProducer.class);

    @Autowired
    public OrderEventProducer(KafkaTemplate<String, OrderCreateEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(OrderCreateEvent order) {
        this.kafkaTemplate.send("orders", order.orderId(), order);
        logger.info("Producer {}", order.eventId());
    }
}
