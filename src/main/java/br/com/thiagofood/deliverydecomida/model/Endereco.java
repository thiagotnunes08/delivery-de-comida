package br.com.thiagofood.deliverydecomida.model;

import javax.persistence.*;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Cliente cliente;

    @Column(nullable = false)
    private String pais;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String complemento;

    public Endereco(Cliente cliente, String pais, String estado, String cidade, String bairro, String rua, String numero, String cep, String complemento) {
        this.cliente = cliente;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.complemento = complemento;
    }

    /**
     * @Deprecated: Uso do Hibernate
     */
    @Deprecated
    public Endereco() {
    }

    public Long getId() {
        return id;
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
