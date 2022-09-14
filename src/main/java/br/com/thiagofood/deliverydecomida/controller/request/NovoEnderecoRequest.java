package br.com.thiagofood.deliverydecomida.controller.request;

import br.com.thiagofood.deliverydecomida.model.Cliente;
import br.com.thiagofood.deliverydecomida.model.Endereco;
import br.com.thiagofood.deliverydecomida.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoEnderecoRequest {

    @NotNull
    private Long dono;
    @NotBlank
    private String pais;
    @NotBlank
    private String estado;
    @NotBlank
    private String cidade;
    @NotBlank
    private String bairro;
    @NotBlank
    private String rua;
    @NotBlank
    private String numero;
    @NotBlank
    private String cep;

    private String complemento;

    public Long getDono() {
        return dono;
    }

    public String getPais() {
        return pais;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getCep() {
        return cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public Endereco toModel(ClienteRepository repository) {

       Cliente cliente = repository.findById(dono)
               .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não econtrado!"));

        return new Endereco(cliente,pais,estado,cidade,bairro,rua,numero,cep,complemento);
    }
}
