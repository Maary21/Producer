package mx.com.baz.ms.kafka.producer.controller;

import org.apache.kafka.common.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.com.baz.confluence.model.Cabecero;
import mx.com.baz.ms.kafka.entity.Customer;
import mx.com.baz.ms.kafka.model.Parametria;
import mx.com.baz.ms.kafka.model.RequestSendKafka;
import mx.com.baz.ms.kafka.producer.MsKafkaProducerApplication;
import mx.com.baz.ms.kafka.producer.dto.ProducerDTO;
import mx.com.baz.ms.kafka.producer.service.CustomerService;
import mx.com.baz.ms.kafka.producer.service.MsKafkaProducerService;
import mx.com.baz.ms.kafka.producer.service.Producer;


@RestController
@RequestMapping("/customers")
@Slf4j
public class ControllerProducer {
	
	@Autowired
	private  CustomerService customerService;
	
	@Autowired
	private Producer producer;
	
	//Parametria parametria = new Parametria();
	

	@PostMapping(value = "/",
			consumes = MediaType.APPLICATION_JSON_VALUE,  
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Cabecero save(@RequestBody Cabecero cabecero) {
		//log.info("save");
		//parametria = MsKafkaProducerApplication.parametria;
		
		return this.customerService.save(cabecero);
		//return new Cabecero();
	}
	

	@PostMapping(value = "/datos",
			consumes = MediaType.APPLICATION_JSON_VALUE,  
			produces = MediaType.APPLICATION_JSON_VALUE)
	//public Boolean
	public RequestSendKafka save(@RequestBody  RequestSendKafka requestSendKafka) {
		log.info("save");
		//parametria = MsKafkaProducerApplication.parametria;
		
		return this.producer.sendMessage(requestSendKafka);
		
		//return new Cabecero();
	}


}
