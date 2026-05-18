package br.com.sandes.addapters.out.client.mapper;

import br.com.sandes.addapters.out.client.response.AddressResponse;
import br.com.sandes.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
