package br.com.sandes.application.core.usecase;

import br.com.sandes.application.core.domain.Customer;
import br.com.sandes.application.ports.in.FindCustomerByIdInputPort;
import br.com.sandes.application.ports.out.FindUserByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindUserByIdOutputPort findUserByIdOutputPort;

    public FindCustomerByIdUseCase(FindUserByIdOutputPort findUserByIdOutputPort) {
        this.findUserByIdOutputPort = findUserByIdOutputPort;
    }

    @Override
    public Customer find(String id) {
        return findUserByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
