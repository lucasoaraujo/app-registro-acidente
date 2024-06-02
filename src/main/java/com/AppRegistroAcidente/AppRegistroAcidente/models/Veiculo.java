package com.AppRegistroAcidente.AppRegistroAcidente.models;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import jakarta.persistence.*;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    private String placa;

    @NotNull
    private String modelo;

    @NotNull
    private String marca;

    @Column(unique = true)
    @NotNull
    private String renavam;

    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL)
    private List<Ocorrencia> ocorrencias;

    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public List<Ocorrencia> getOcorrencias() {
        if (ocorrencias == null) {
            ocorrencias = new ArrayList<>();
        }
        return ocorrencias;
    }

    public void setOcorrencias(List<Ocorrencia> ocorrencias) {
        this.ocorrencias = ocorrencias;
    }
}
