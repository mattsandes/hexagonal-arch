package br.com.sandes.application.core.usecase;

import br.com.sandes.application.ports.in.DeleteCustomerByIdInputPort;
import br.com.sandes.application.ports.in.FindCustomerByIdInputPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {

    private final DeleteCustomerByIdUseCase deleteCustomerByIdUseCase;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    public DeleteCustomerByIdUseCase(
            DeleteCustomerByIdUseCase deleteCustomerByIdUseCase,
            FindCustomerByIdInputPort findCustomerByIdInputPort) {
        this.deleteCustomerByIdUseCase = deleteCustomerByIdUseCase;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
    }

    @Override
    public void delete(String id) {
        var customer = findCustomerByIdInputPort.find(id);

        deleteCustomerByIdUseCase.delete(customer.getId());
    }
}
