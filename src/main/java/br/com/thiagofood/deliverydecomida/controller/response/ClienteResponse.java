package br.com.thiagofood.deliverydecomida.controller.response;

import br.com.thiagofood.deliverydecomida.model.Cliente;
import br.com.thiagofood.deliverydecomida.model.Endereco;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteResponse {

    private String nome;
    private String email;
    private String celular;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<EnderecoResponse> enderecos = new ArrayList<>();

    public ClienteResponse(Cliente cliente, Boolean deveListarEndereco) {
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.celular = cliente.getCelular();
        if (deveListarEndereco.equals(true)){
            this.enderecos = cliente.getEnderecos().stream().map(EnderecoResponse::new).collect(Collectors.toList());
        }
    }


    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCelular() {
        return celular;
    }

    public List<EnderecoResponse> getEnderecos() {
        return enderecos;
    }
}
