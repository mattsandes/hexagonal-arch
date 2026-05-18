package br.com.sandes.addapters.out.repository;

import br.com.sandes.addapters.out.repository.entites.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
}
