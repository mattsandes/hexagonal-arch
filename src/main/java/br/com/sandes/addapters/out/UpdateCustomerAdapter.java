package br.com.sandes.addapters.out;

import br.com.sandes.addapters.out.repository.CustomerRepository;
import br.com.sandes.addapters.out.repository.mapper.CustomerEntityMapper;
import br.com.sandes.application.core.domain.Customer;
import br.com.sandes.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    private final CustomerEntityMapper mapper;
    private final CustomerRepository customerRepository;

    public UpdateCustomerAdapter(
            CustomerEntityMapper mapper,
            CustomerRepository customerRepository) {
        this.mapper = mapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public void update(Customer customer) {
        var customerEntity = mapper.toCustomerEntity(customer);

        customerRepository.save(customerEntity);
    }
}
