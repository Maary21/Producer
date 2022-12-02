package mx.com.baz.ms.kafka.producer.service;

import java.text.ParseException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.com.baz.confluence.model.Cabecero;
import mx.com.baz.ms.kafka.model.RequestSendKafka;

@Service
@Slf4j
public class ProducerImpl implements Producer {
	/*modificar topic*/
	@Value("${topic.customer.name:ecosistema_topic}") //baz_topic_confluence
	private String topic;
	
	@Autowired
	private KafkaTemplate<String, Cabecero> kafkaTemplate;


	@Override
	public Boolean sendMessages(String key, Cabecero cabecero) {
		try {
			this.sendMessage(key, cabecero);
	    	return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*private void sendMessage(Integer partition, String key, Cabecero message) {
	    log.debug(String.format("#### -> Producing message -> %s", message.toString()));
        kafkaTemplate.send(topic, partition, key, message);
		
	}*/
	
	private void sendMessage(String key, Cabecero message) {
	    log.debug(String.format("#### -> Producing message -> %s", message.toString()));
        kafkaTemplate.send(topic, key, message);
		
	}

	@Override
	public RequestSendKafka sendMessage(RequestSendKafka requestSendKafka) {
		try {
			Cabecero movimiento = requestSendKafka.getCabecero();
	    	
			//this.sendMessage(requestSendKafka.getPartition(), requestSendKafka.getKey(), movimiento);
			this.sendMessage(requestSendKafka.getKey(), movimiento);

			//return true;
		} catch (Exception e) {
			e.printStackTrace();
			//return false;
		}
		return requestSendKafka;
	}

	@Override
	public String getKey(Cabecero movimiento, Integer consecutivo) throws ParseException {
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
//		Date dateA = sdf.parse(movimiento.getTransaccion().getCabecero().getFdTransFechr());
//		sdf = new SimpleDateFormat("yyyyMMdd");
//		String cadenaFecha = sdf.format(dateA);
//		String key = (movimiento.getTransaccion().getCabecero().getFiTranNo()).concat(cadenaFecha).concat(String.format("%06d", consecutivo));
    	String key = UUID.randomUUID().toString();
		return key;
	}

}
