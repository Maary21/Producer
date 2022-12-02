package mx.com.baz.ms.kafka.producer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import mx.com.baz.ms.kafka.model.GenericResponse;
import mx.com.baz.ms.kafka.model.PlKeyValueRequest;

@Component
public class DBPropertyLoader {
	private static boolean arePropertiesLoadedFromDatabase = false;
	private static final String PROPERTY_SOURCE_NAME = "databaseProperties";
	
	public void  postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		RestTemplate restTemplate = new RestTemplate();
		String url = environment.getProperty("url.base.endpoint.conf.bd");

		if (!arePropertiesLoadedFromDatabase) {
			PlKeyValueRequest request = new PlKeyValueRequest();
			request.setIdAplicacion(Integer.valueOf(environment.getProperty("info.microservice.id")));
			request.setTipoCoinciliacion(Integer.valueOf(environment.getProperty("info.microservice.tipoCoin")));
			request.setTipoDatos(2);

			GenericResponse respuesta = restTemplate.postForObject(url, request, GenericResponse.class);
			ArrayList<?> lista = (ArrayList<?>)respuesta.getResponse();

			Map<String, Object> mapa = new HashMap<String, Object>();

			@SuppressWarnings("unchecked")
			Iterator<LinkedHashMap<String, Object>> it = (Iterator<LinkedHashMap<String, Object>>)lista.iterator();
			while(it.hasNext()) {
				LinkedHashMap<String, Object> objResponse = it.next();
				mapa.put((String)objResponse.get("key_R"), objResponse.get("value_R"));

			}

			environment.getPropertySources().addLast(new MapPropertySource(PROPERTY_SOURCE_NAME, mapa));
		}
		arePropertiesLoadedFromDatabase = true;
}
}
