package br.com.thiagofood.deliverydecomida.controller;

import br.com.thiagofood.deliverydecomida.controller.request.AtualizaClienteRequest;
import br.com.thiagofood.deliverydecomida.model.Cliente;
import br.com.thiagofood.deliverydecomida.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("api/clientes")
public class AtualizaDadosDoClienteController {

    private final ClienteRepository repository;

    public AtualizaDadosDoClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualiza(@PathVariable Long id, @Valid @RequestBody AtualizaClienteRequest request) {

        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));

        request.getEmail().ifPresent(possivelEmail -> {
            if (repository.existsByEmail(request.getEmail())) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Email já existente no sistema!");
            }
        });

        cliente.atualiza(request);

        return ResponseEntity.noContent().build();

    }
}
