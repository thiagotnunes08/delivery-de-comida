package br.com.thiagofood.deliverydecomida.controller.request;

import br.com.thiagofood.deliverydecomida.model.Cliente;
import br.com.thiagofood.deliverydecomida.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;

public class AtualizaClienteRequest {

    private String nome;

    private String telefone;
    @Email
    private String email;

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public void verificaClienteExistente(ClienteRepository repository) {

        if (repository.existsByEmail(email)){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"Cliente já existente no sistema com esse email!");
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void atualizaCampos(Cliente clienteAutalizado) {

        if (nome != null) clienteAutalizado.setNome(nome);
        if (telefone != null) clienteAutalizado.setCelular(telefone);
        if (email != null) clienteAutalizado.setEmail(email);

    }
}
