package br.com.thiagofood.deliverydecomida.model;


import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.*;

@Entity
@Table(uniqueConstraints =
@UniqueConstraint(name = "UK_cpf_email"
        ,columnNames = {"email","cpf"}))
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String celular;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private LocalDateTime criadoEm = now();

    @UpdateTimestamp
    private LocalDateTime modificadoEm;

    public Cliente(String nome, String email, String celular, String cpf) {
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.cpf = cpf;
    }

    /**
     * @Deprecated: Uso do Hibernate
     */
    @Deprecated
    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

}
