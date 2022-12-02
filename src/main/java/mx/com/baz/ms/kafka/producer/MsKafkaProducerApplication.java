package mx.com.baz.ms.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;
import mx.com.baz.ms.kafka.model.Parametria;
import mx.com.baz.ms.kafka.producer.service.RestClientService;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class MsKafkaProducerApplication {

	//@Autowired
	//RestClientService restClient;
	
	//public static Parametria parametria = new Parametria();
	public static void main(String[] args) {
		SpringApplication.run(MsKafkaProducerApplication.class, args);
	}
	
	/*public void run(String... args) throws Exception {
		log.info("------------ Inicia la carga de Parametria ------------");
		parametria = restClient.getParametria();
		if(parametria == null) {
			log.error("No se pudo cargar la parametría");
			throw new Exception("No se pudo cargar la parametría");
		}
	}*/
}
