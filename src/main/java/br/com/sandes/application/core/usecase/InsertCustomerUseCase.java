package br.com.sandes.application.core.usecase;

import br.com.sandes.application.core.domain.Customer;
import br.com.sandes.application.ports.in.InsertCustomerInputPort;
import br.com.sandes.application.ports.out.FindAddressByZipcodeOutputPort;
import br.com.sandes.application.ports.out.InsertCustomerOutputPort;
import br.com.sandes.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private SendCpfForValidationOutputPort  sendCpfForValidationOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;
    private final FindAddressByZipcodeOutputPort findAddressByZipcodeOutputPort;

    public InsertCustomerUseCase(
            InsertCustomerOutputPort insertCustomerOutputPort,
            FindAddressByZipcodeOutputPort findAddressByZipcodeOutputPort,
            SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.findAddressByZipcodeOutputPort = findAddressByZipcodeOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipcode) {
        var address = findAddressByZipcodeOutputPort.find(zipcode);

        customer.setAddress(address);

        insertCustomerOutputPort.insert(customer);

        sendCpfForValidationOutputPort.send(customer.getCpf());
    }
}
