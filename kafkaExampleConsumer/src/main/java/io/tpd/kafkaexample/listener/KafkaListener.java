package io.tpd.kafkaexample.listener;

import io.tpd.kafkaexample.model.PraticalAdvice;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.StreamSupport;

@RestController
public class KafkaListener {
    private static final Logger logger =
            LoggerFactory.getLogger(KafkaListener.class);

    private final KafkaTemplate<String, Object> template;
    private final String topicName;

    public KafkaListener(
            final KafkaTemplate<String, Object> template,
            @Value("${tpd.topic-name}") final String topicName) {
        this.template = template;
        this.topicName = topicName;
    }

    @org.springframework.kafka.annotation.KafkaListener(topics = "advice-topic", clientIdPrefix = "json",
            containerFactory = "kafkaListenerContainerFactory")
    public void listenAsObject(ConsumerRecord<String, PraticalAdvice> cr,
                               @Payload PraticalAdvice payload) {
        logger.info("Logger 1 [JSON] received key {}: Type [{}] | Payload: {} | Record: {}", cr.key(),
                typeIdHeader(cr.headers()), payload.toString(), cr);
    }

    private static String typeIdHeader(Headers headers) {
        return StreamSupport.stream(headers.spliterator(), false)
                .filter(header -> header.key().equals("__TypeId__"))
                .findFirst().map(header -> new String(header.value())).orElse("N/A");
    }
}
