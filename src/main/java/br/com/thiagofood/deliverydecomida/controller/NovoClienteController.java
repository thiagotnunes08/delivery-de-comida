package br.com.thiagofood.deliverydecomida.controller;

import br.com.thiagofood.deliverydecomida.controller.request.NovoClienteRequest;
import br.com.thiagofood.deliverydecomida.model.Cliente;
import br.com.thiagofood.deliverydecomida.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/clientes")
public class NovoClienteController {

    @Autowired
    private final ClienteRepository repository;

    public NovoClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> cadastra(@Valid @RequestBody NovoClienteRequest request, UriComponentsBuilder uriComponentsBuilder){

        if (repository.existsByEmailOrCpf(request.getEmail(),request.getCpf())){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"Cliente já existente no sistema com esse email ou CPF");
        }

        Cliente novoCliente = request.toModel();

        repository.save(novoCliente);

        URI location = uriComponentsBuilder.path("api/clientes/{id}").buildAndExpand(novoCliente.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
