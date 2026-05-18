package br.com.sandes.addapters.out;

import br.com.sandes.addapters.out.repository.CustomerRepository;
import br.com.sandes.addapters.out.repository.mapper.CustomerEntityMapper;
import br.com.sandes.application.core.domain.Customer;
import br.com.sandes.application.ports.out.FindUserByIdOutputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindUserByIdOutputPort {

    private final CustomerEntityMapper mapper;
    private final CustomerRepository customerRepository;

    public FindCustomerByIdAdapter(
            CustomerEntityMapper mapper,
            CustomerRepository customerRepository) {
        this.mapper = mapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);

        return customerEntity.map(mapper::toCustomer);
    }
}
