package br.com.thiagofood.deliverydecomida.controller;

import br.com.thiagofood.deliverydecomida.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/enderecos")
public class RemoveEnderecoController {

    @Autowired
    private final EnderecoRepository repository;

    public RemoveEnderecoController(EnderecoRepository repository) {
        this.repository = repository;
    }

    @DeleteMapping("/{restauranteId}")
    public ResponseEntity<?> remove(@PathVariable Long restauranteId) {

        repository.findById(restauranteId)
                .ifPresentOrElse(repository::delete, () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurante não foi encontrado!");
                        }
                )
        ;

        return ResponseEntity.noContent().build();

    }
}
