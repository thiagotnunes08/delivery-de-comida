package br.com.thiagofood.deliverydecomida.controller.response;

import br.com.thiagofood.deliverydecomida.model.Endereco;

public class EnderecoResponse {


    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String cep;

    public EnderecoResponse(Endereco endereco) {
        this.cidade = endereco.getCidade();
        this.bairro = endereco.getBairro();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.cep = endereco.getCep();
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
}
