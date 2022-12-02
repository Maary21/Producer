package mx.com.baz.ms.kafka.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.com.baz.confluence.model.Cabecero;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestSendKafka {
	private String key;
	//private Integer partition;
	private Cabecero cabecero;
}
