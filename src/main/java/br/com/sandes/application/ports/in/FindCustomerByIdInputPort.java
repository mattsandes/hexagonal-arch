package br.com.sandes.application.ports.in;

import br.com.sandes.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {
    Customer find(String id);
}
