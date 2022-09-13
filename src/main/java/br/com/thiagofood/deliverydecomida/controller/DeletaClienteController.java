package br.com.thiagofood.deliverydecomida.controller;

import br.com.thiagofood.deliverydecomida.controller.request.DeletaClienteRequest;
import br.com.thiagofood.deliverydecomida.model.Cliente;
import br.com.thiagofood.deliverydecomida.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/clientes/")
public class DeletaClienteController {
    @Autowired
    private final ClienteRepository repository;

    public DeletaClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @DeleteMapping("/email")
    public ResponseEntity<?> deleta(@RequestBody DeletaClienteRequest request) {

        Cliente cliente = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Email não foi encontrado!"));

        repository.delete(cliente);

        return ResponseEntity.noContent().build();
    }
}
