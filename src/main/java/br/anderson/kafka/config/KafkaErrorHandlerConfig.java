package br.anderson.kafka.config;

import br.anderson.kafka.exceptions.InvalidOrderException;
import org.apache.kafka.common.TopicPartition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
public class KafkaErrorHandlerConfig {

    @Bean
    public DefaultErrorHandler kafkaErrorHandler(KafkaTemplate<?, ?> kafkaTemplate) {
        var recover = new DeadLetterPublishingRecoverer(
                kafkaTemplate,
                (consumerRecord, exception) -> new TopicPartition(consumerRecord.topic() + "-DLT", consumerRecord.partition()));
        var backOff = new FixedBackOff(1_000L, 3L);

        var errorHandler = new DefaultErrorHandler(recover, backOff);
        errorHandler.addNotRetryableExceptions(InvalidOrderException.class);

        return errorHandler;
    }
}
