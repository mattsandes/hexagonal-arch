package br.com.sandes.config;

import br.com.sandes.addapters.out.FindCustomerByIdAdapter;
import br.com.sandes.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(FindCustomerByIdAdapter findCustomerByIdAdapter) {
        return new  FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }
}
