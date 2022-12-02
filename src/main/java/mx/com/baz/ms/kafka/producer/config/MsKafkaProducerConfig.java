package mx.com.baz.ms.kafka.producer.config;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;

import mx.com.baz.confluence.model.Cabecero;
import mx.com.baz.ms.kafka.Event.Event;
import mx.com.baz.ms.kafka.producer.dto.ProducerDTO;
import reactor.kafka.sender.SenderOptions;

import java.util.Map;

import java.util.HashMap;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class MsKafkaProducerConfig {
	
	private final String bootstrapAddress = "10.82.56.194:9092";
    
	@Bean
	public ProducerFactory<String, Cabecero> producerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		configProps.put(ProducerConfig.LINGER_MS_CONFIG, "1");
		configProps.put(ProducerConfig.BATCH_SIZE_CONFIG, "32384");
		configProps.put(ProducerConfig.BUFFER_MEMORY_CONFIG, "33554432");
		return new DefaultKafkaProducerFactory<>(configProps);
	}

    @Bean
    public KafkaTemplate<String, Cabecero> kafkaTemplate() {
        
    	return new KafkaTemplate<>(producerFactory());
    }
}