package br.com.sandes.config;

import br.com.sandes.addapters.out.FindAddressByZipcodeAdapter;
import br.com.sandes.addapters.out.InsertCustomerAdapter;
import br.com.sandes.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipcodeAdapter findAddressByZipcodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter)
    {
        return new InsertCustomerUseCase(
                insertCustomerAdapter,
                findAddressByZipcodeAdapter);
    }
}
