package io.tpd.kafkaexample.producer;

import io.tpd.kafkaexample.model.PraticalAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class KafkaProducer {
    private static final Logger logger =
            LoggerFactory.getLogger(KafkaProducer.class);

    private final KafkaTemplate<String, Object> template;
    private final String topicName;

    public KafkaProducer(
            final KafkaTemplate<String, Object> template,
            @Value("${tpd.topic-name}") final String topicName) {
        this.template = template;
        this.topicName = topicName;
    }

    @Scheduled(fixedDelay = 60000)
    public void produce() {
        logger.info("Sending kafka message");
        this.template.send(topicName, String.valueOf(UUID.randomUUID()),
                new PraticalAdvice("Message produced at {}", LocalDateTime.now()));
    }

}
