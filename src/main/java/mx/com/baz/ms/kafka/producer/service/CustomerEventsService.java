package mx.com.baz.ms.kafka.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import mx.com.baz.confluence.model.Cabecero;
import mx.com.baz.ms.kafka.Event.CustomerCreatedEvent;
import mx.com.baz.ms.kafka.Event.EvenType;
import mx.com.baz.ms.kafka.Event.Event;
import mx.com.baz.ms.kafka.entity.Customer;


import java.util.Date;
import java.util.UUID;

@Component
public class CustomerEventsService {
	
	@Autowired
	private KafkaTemplate<String, Cabecero> producer;
	
	@Value("${topic.customer.name:ecosistema_topic}")  //baz_topic_confluence
	private String topicCustomer;
	
	public void publish(Cabecero cabecero) {

		//CustomerCreatedEvent created = new CustomerCreatedEvent();
		//setCabecero(cabecero);
		this.producer.send(topicCustomer ,cabecero);
	}

}
