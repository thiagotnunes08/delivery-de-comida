package br.com.thiagofood.deliverydecomida.controller;

import br.com.thiagofood.deliverydecomida.controller.request.NovoEnderecoRequest;
import br.com.thiagofood.deliverydecomida.model.Endereco;
import br.com.thiagofood.deliverydecomida.repository.ClienteRepository;
import br.com.thiagofood.deliverydecomida.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/enderecos")
public class NovoEnderecoController {

    @Autowired
    private final ClienteRepository clienteRepository;

    @Autowired
    private final EnderecoRepository enderecoRepository;

    public NovoEnderecoController(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastra(@Valid @RequestBody NovoEnderecoRequest request, UriComponentsBuilder uriComponentsBuilder){

        Endereco novoEndereco = request.toModel(clienteRepository);

        enderecoRepository.save(novoEndereco);

        URI location = uriComponentsBuilder.path("api/enderecos/{id}").buildAndExpand(novoEndereco.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
