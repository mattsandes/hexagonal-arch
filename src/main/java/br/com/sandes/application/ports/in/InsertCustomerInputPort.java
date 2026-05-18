package br.com.sandes.application.ports.in;

import br.com.sandes.application.core.domain.Customer;

public interface InsertCustomerInputPort {
    void insert(Customer customer, String zipcode);
}
