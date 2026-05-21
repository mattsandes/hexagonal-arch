package br.com.sandes.addapters.in.consumer.message;

public record CustomerMessage(
        String id,
        String name,
        String zipcode,
        String cpf,
        Boolean isValidCpf
) {
}
