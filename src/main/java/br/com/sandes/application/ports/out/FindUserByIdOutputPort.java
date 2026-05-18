package br.com.sandes.application.ports.out;

import br.com.sandes.application.core.domain.Customer;

import java.util.Optional;

public interface FindUserByIdOutputPort {
    Optional<Customer> find(String id);
}
