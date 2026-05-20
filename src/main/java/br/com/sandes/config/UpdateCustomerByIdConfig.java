package br.com.sandes.config;

import br.com.sandes.addapters.out.FindAddressByZipcodeAdapter;
import br.com.sandes.addapters.out.UpdateCustomerAdapter;
import br.com.sandes.application.core.usecase.FindCustomerByIdUseCase;
import br.com.sandes.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerByIdConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomer(
            FindAddressByZipcodeAdapter findAddressByZipcodeAdapter,
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            UpdateCustomerAdapter updateCustomerAdapter

    )
    {
        return new UpdateCustomerUseCase(
                updateCustomerAdapter,
                findAddressByZipcodeAdapter,
                findCustomerByIdUseCase);
    }
}
