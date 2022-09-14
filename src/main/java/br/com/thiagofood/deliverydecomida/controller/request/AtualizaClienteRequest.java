package br.com.thiagofood.deliverydecomida.controller.request;

import br.com.thiagofood.deliverydecomida.model.Cliente;
import br.com.thiagofood.deliverydecomida.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Optional;

public class AtualizaClienteRequest {


    private String nome;

    private String telefone;
    @Email
    private String email;

    public Optional<String> getNome() {
        return Optional.ofNullable(nome);
    }

    public Optional<String> getTelefone() {
        return Optional.ofNullable(telefone);
    }

    public Optional<String> getEmail() {

        return Optional.ofNullable(email);

    }


}
