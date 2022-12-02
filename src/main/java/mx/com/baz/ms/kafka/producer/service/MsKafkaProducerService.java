package mx.com.baz.ms.kafka.producer.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Service;

import mx.com.baz.ms.kafka.producer.dto.ProducerDTO;

@Service
public class MsKafkaProducerService {
/*
    private final Logger log = LoggerFactory.getLogger(MsKafkaProducerService.class);
    private final ReactiveKafkaProducerTemplate<String, ProducerDTO> reactiveKafkaProducerTemplate;

    @Value(value = "${PRODUCER_DTO_TOPIC}")
    private String topic;

    public MsKafkaProducerService(ReactiveKafkaProducerTemplate<String, ProducerDTO> reactiveKafkaProducerTemplate) {
        this.reactiveKafkaProducerTemplate = reactiveKafkaProducerTemplate;
    }
    
    public void send(ProducerDTO fakeProducerDTO) {
    	String key = UUID.randomUUID().toString();
        log.info("send to topic={}, {}={},", topic, ProducerDTO.class.getSimpleName(), fakeProducerDTO);
        //reactiveKafkaProducerTemplate.send(topic, key, fakeProducerDTO)
        reactiveKafkaProducerTemplate.send(topic, key, fakeProducerDTO)
                .doOnSuccess(senderResult -> log.info("sent {} offset : {}", fakeProducerDTO, senderResult.recordMetadata().offset()))
                .subscribe();
    }*/
}