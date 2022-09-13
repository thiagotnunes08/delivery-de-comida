package br.com.thiagofood.deliverydecomida.repository;

import br.com.thiagofood.deliverydecomida.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
}
