package br.com.sandes.addapters.out.repository.entites;

import lombok.Data;

@Data
public class CustomerEntity {

    private String id;
    private String name;
    private AddressEntity address;
    private String cpf;
    private Boolean isValidCpf;
}
