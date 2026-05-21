package br.com.sandes.addapters.in.consumer;

import br.com.sandes.addapters.in.consumer.mapper.CustomerMessageMapper;
import br.com.sandes.addapters.in.consumer.message.CustomerMessage;
import br.com.sandes.application.ports.in.UpdateCustomerInputPort;
import org.springframework.kafka.annotation.KafkaListener;

public class ReceiveValidateCpfConsumer {

    private final CustomerMessageMapper mapper;
    private final UpdateCustomerInputPort  updateCustomerInputPort;

    public ReceiveValidateCpfConsumer(
            CustomerMessageMapper mapper,
            UpdateCustomerInputPort updateCustomerInputPort) {
        this.mapper = mapper;
        this.updateCustomerInputPort = updateCustomerInputPort;
    }

    @KafkaListener(topics = "tp-cpf-validate", groupId = "sandes")
    public void receive(CustomerMessage message) {
        var customer = mapper.toCustomer(message);

        updateCustomerInputPort.update(customer, message.zipcode());
    }
}
