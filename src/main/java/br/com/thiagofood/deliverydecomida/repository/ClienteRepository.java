package br.com.thiagofood.deliverydecomida.repository;

import br.com.thiagofood.deliverydecomida.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    boolean existsByEmailOrCpf(String email, String cpf);

    Optional<Cliente> findByEmail(String email);

    boolean existsByEmail(Optional<String> email);
}
