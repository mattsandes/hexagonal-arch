package br.com.sandes.application.ports.out;

import br.com.sandes.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);
}
