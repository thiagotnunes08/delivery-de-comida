package br.com.thiagofood.deliverydecomida.controller;

import br.com.thiagofood.deliverydecomida.controller.response.ClienteResponse;
import br.com.thiagofood.deliverydecomida.model.Cliente;
import br.com.thiagofood.deliverydecomida.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/clientes")
public class ConsultarClienteController {

    private final ClienteRepository repository;

    public ConsultarClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consulta(@PathVariable Long id, @RequestParam(required = false, value = "mostrarEndereco") Boolean deveListarEndereco) {

        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));


        return ResponseEntity.ok(new ClienteResponse(cliente, deveListarEndereco));


    }
}
