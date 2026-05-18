package br.com.sandes.addapters.out;

import br.com.sandes.addapters.out.client.FindAddressByZipcodeClient;
import br.com.sandes.addapters.out.client.mapper.AddressResponseMapper;
import br.com.sandes.application.core.domain.Address;
import br.com.sandes.application.ports.out.FindAddressByZipcodeOutputPort;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipcodeAdapter implements FindAddressByZipcodeOutputPort {

    private final AddressResponseMapper addressResponseMapper;
    private final FindAddressByZipcodeClient findAddressByZipcodeClient;

    public FindAddressByZipcodeAdapter(
            AddressResponseMapper addressResponseMapper,
            FindAddressByZipcodeClient findAddressByZipcodeClient) {
        this.addressResponseMapper = addressResponseMapper;
        this.findAddressByZipcodeClient = findAddressByZipcodeClient;
    }

    @Override
    public Address find(String zipcode) {
        var addressResponse = findAddressByZipcodeClient.find(zipcode);

        return addressResponseMapper.toAddress(addressResponse);
    }
}
