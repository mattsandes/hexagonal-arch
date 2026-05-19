package br.com.sandes.addapters.out;

import br.com.sandes.addapters.out.repository.CustomerRepository;
import br.com.sandes.application.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

    private final CustomerRepository customerRepository;

    public DeleteCustomerByIdAdapter(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void deleteById(String id) {
        customerRepository.deleteById(id);
    }
}
