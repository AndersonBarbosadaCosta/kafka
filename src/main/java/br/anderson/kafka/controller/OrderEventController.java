package br.anderson.kafka.controller;

import br.anderson.kafka.model.OrderCreateEvent;
import br.anderson.kafka.producer.OrderEventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class OrderEventController {

    private final OrderEventProducer eventProducer;

    @Autowired
    public OrderEventController(OrderEventProducer eventProducer) {
        this.eventProducer = eventProducer;
    }

    @PostMapping("/send")
    public void sendOrder(@RequestBody OrderCreateEvent payload) {
        eventProducer.publish(payload);
        ResponseEntity.ok().build();
    }
}
