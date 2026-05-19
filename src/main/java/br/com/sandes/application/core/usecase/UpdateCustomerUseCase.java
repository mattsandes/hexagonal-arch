package br.com.sandes.application.core.usecase;

import br.com.sandes.application.core.domain.Customer;
import br.com.sandes.application.ports.in.FindCustomerByIdInputPort;
import br.com.sandes.application.ports.in.UpdateCustomerInputPort;
import br.com.sandes.application.ports.out.FindAddressByZipcodeOutputPort;
import br.com.sandes.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final UpdateCustomerOutputPort updateCustomerOutputPort;
    private final FindAddressByZipcodeOutputPort findAddressByZipcodeOutputPort;
    private final FindCustomerByIdInputPort findCustomerByIdInput;

    public UpdateCustomerUseCase(
            UpdateCustomerOutputPort updateCustomerOutputPort,
            FindAddressByZipcodeOutputPort  findAddressByZipcodeOutputPort,
            FindCustomerByIdInputPort findCustomerByIdInput) {
        this.updateCustomerOutputPort = updateCustomerOutputPort;
        this.findAddressByZipcodeOutputPort = findAddressByZipcodeOutputPort;
        this.findCustomerByIdInput = findCustomerByIdInput;
    }

    @Override
    public void update(Customer customer, String zipcode) {
        var foundCustomer = findCustomerByIdInput.find(customer.getId());

        var address = findAddressByZipcodeOutputPort.find(zipcode);

        customer.setAddress(address);

        updateCustomerOutputPort.update(customer);
    }
}
