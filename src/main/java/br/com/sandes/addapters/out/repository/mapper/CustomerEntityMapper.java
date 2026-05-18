package br.com.sandes.addapters.out.repository.mapper;

import br.com.sandes.addapters.out.repository.entites.CustomerEntity;
import br.com.sandes.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    CustomerEntity toCustomerEntity(Customer customer);
    Customer toCustomer(CustomerEntity customerEntity);
}
