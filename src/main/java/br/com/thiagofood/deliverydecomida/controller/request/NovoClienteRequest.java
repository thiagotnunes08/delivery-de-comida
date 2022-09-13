package br.com.thiagofood.deliverydecomida.controller.request;

import br.com.thiagofood.deliverydecomida.model.Cliente;
import ch.qos.logback.core.net.server.Client;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NovoClienteRequest {

    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    private String celular;
    @NotBlank
    @CPF
    private String cpf;


    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCelular() {
        return celular;
    }

    public String getCpf() {
        return cpf;
    }

    public Cliente toModel() {
        return new Cliente(nome,email,celular,cpf);

    }
}
