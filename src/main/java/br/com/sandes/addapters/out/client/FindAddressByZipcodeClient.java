package br.com.sandes.addapters.out.client;

import br.com.sandes.addapters.out.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "FindAddressByZipcodeClient",
        url = "${sandes.client.url}"
)
public interface FindAddressByZipcodeClient {

    @GetMapping(value = "/{zipcode}")
    AddressResponse find(@PathVariable String zipcode);
}
