package com.AppRegistroAcidente.AppRegistroAcidente.models;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class Cidadao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 50)
    private String nome;

    @Column(unique = true)
    @NotNull
    @Size(max = 14)
    private String cpf;

    @NotNull
    @Size(max = 50)
    private String endereco;

    @NotNull
    @Size(max = 15)
    private String telefone;

    @Column(unique = true)
    @NotNull
    @Size(max = 50)
    private String email;

    @OneToMany(mappedBy = "cidadao", cascade = CascadeType.ALL)
    private List<Ocorrencia> ocorrencias;

    @OneToOne
    @JoinColumn(name = "conta_gov_id")
    private ContaGov contaGov;

    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ContaGov getContaGov() {
        return contaGov;
    }

    public void setContaGov(ContaGov contaGov) {
        this.contaGov = contaGov;
    }

    public List<Ocorrencia> getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(List<Ocorrencia> ocorrencias) {
        this.ocorrencias = ocorrencias;
    }
}
