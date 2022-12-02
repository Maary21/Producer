package mx.com.baz.ms.kafka.producer.service;

import java.text.ParseException;

import mx.com.baz.confluence.model.Cabecero;
import mx.com.baz.ms.kafka.model.RequestSendKafka;

public interface Producer {
	//public Boolean sendMessages(String key, Integer partition, Cabecero movimiento);
	public Boolean sendMessages(String key, Cabecero movimiento);

	public RequestSendKafka sendMessage(RequestSendKafka requestSendKafka);
	String getKey(Cabecero movimiento, Integer consecutivo) throws ParseException;
	//public void sendMessages(String key, int partition, RequestSendKafka requestSendKafka);

}
