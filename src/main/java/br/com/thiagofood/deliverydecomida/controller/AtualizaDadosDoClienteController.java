package br.com.thiagofood.deliverydecomida.controller;

import br.com.thiagofood.deliverydecomida.controller.request.AtualizaClienteRequest;
import br.com.thiagofood.deliverydecomida.model.Cliente;
import br.com.thiagofood.deliverydecomida.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("api/clientes")
public class AtualizaDadosDoClienteController {

    private final ClienteRepository repository;

    public AtualizaDadosDoClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> atualiza(@PathVariable Long id, @RequestBody AtualizaClienteRequest request) {

        Cliente clienteAutalizado = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));

        request.verificaClienteExistente(repository);

        request.atualizaCampos(clienteAutalizado);

        repository.save(clienteAutalizado);

        return ResponseEntity.noContent().build();


    }
}
