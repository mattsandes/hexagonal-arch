package br.com.sandes.application.ports.out;

import br.com.sandes.application.core.domain.Address;

public interface FindAddressByZipcodeOutputPort {

    Address find(String zipcode);
}
