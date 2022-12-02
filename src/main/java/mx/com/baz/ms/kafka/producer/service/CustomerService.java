package mx.com.baz.ms.kafka.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.baz.confluence.model.Cabecero;

@Service
public class CustomerService {
	
	@Autowired
	private final CustomerEventsService customerEventsService;

	public CustomerService(CustomerEventsService customerEventsService) {
		super();
		this.customerEventsService = customerEventsService;
	}

	public Cabecero save(Cabecero cabecero) {
		System.out.println("Received " + cabecero);
		this.customerEventsService.publish(cabecero);
		return cabecero;
	}
	

}