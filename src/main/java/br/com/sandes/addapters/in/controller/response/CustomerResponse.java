package br.com.sandes.addapters.in.controller.response;

import br.com.sandes.application.core.domain.Address;

public record CustomerResponse(
        String id,
        String name,
        Address address,
        String cpf,
        Boolean isValidCpf) {
}
