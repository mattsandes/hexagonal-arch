package br.com.sandes.config;

import br.com.sandes.addapters.out.DeleteCustomerByIdAdapter;
import br.com.sandes.application.core.usecase.DeleteCustomerByIdUseCase;
import br.com.sandes.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerById(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
    ) {
        return new DeleteCustomerByIdUseCase(deleteCustomerByIdAdapter, findCustomerByIdUseCase);
    }
}
