package mx.com.baz.ms.kafka.Event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.com.baz.ms.kafka.entity.Customer;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerCreatedEvent extends Event<Customer> {

}