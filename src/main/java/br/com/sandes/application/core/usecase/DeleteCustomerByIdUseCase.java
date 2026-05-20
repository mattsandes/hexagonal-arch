package br.com.sandes.application.core.usecase;

import br.com.sandes.application.ports.in.DeleteCustomerByIdInputPort;
import br.com.sandes.application.ports.in.FindCustomerByIdInputPort;
import br.com.sandes.application.ports.out.DeleteCustomerByIdOutputPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {

    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    public DeleteCustomerByIdUseCase(
            DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort,
            FindCustomerByIdInputPort findCustomerByIdInputPort) {
        this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
    }

    @Override
    public void delete(String id) {
        var customer = findCustomerByIdInputPort.find(id);

        deleteCustomerByIdOutputPort.deleteById(customer.getId());
    }
}
