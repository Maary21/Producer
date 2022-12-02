package mx.com.baz.ms.kafka.producer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Producer")
public class ProducerDTO {
    @JsonProperty("id")
    private String id;

    public ProducerDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProducerDTO{" +
                "id='" + id + '\'' +
                '}';
    }
}