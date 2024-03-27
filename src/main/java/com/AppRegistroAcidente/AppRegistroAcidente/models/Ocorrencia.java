package com.AppRegistroAcidente.AppRegistroAcidente.models;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Size;

@Entity
public class Ocorrencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(max = 10)
    private String dataHora;
    
    @NotNull
    @Size(max = 15)
    private String localizacao;
    
    @NotNull
    @Lob
    private String descricao;
    
    @NotNull
    @Lob
    private String fotos;
    
    @NotNull
    @Size(max = 15)
    private String situacao;
    
    @OneToMany(mappedBy = "ocorrencia")
    private List<ParteEnvolvida> partesEnvolvidas;
    
    @OneToOne
    @JoinColumn(name = "cidadao_id")
    private Cidadao cidadao;
    
    @OneToMany(mappedBy = "ocorrencia", cascade = CascadeType.ALL)
    private List<Veiculo> veiculos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFotos() {
        return fotos;
    }

    public void setFotos(String fotos) {
        this.fotos = fotos;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public List<ParteEnvolvida> getPartesEnvolvidas() {
        return partesEnvolvidas;
    }

    public void setPartesEnvolvidas(List<ParteEnvolvida> partesEnvolvidas) {
        this.partesEnvolvidas = partesEnvolvidas;
    }

    public Cidadao getCidadao() {
        return cidadao;
    }

    public void setCidadao(Cidadao cidadao) {
        this.cidadao = cidadao;
    }

    public List<Veiculo> getVeiculos() {
        if (veiculos == null) {
            veiculos = new ArrayList<>();
        }
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

	public void setVeiculo(Veiculo veiculo) {
		// TODO Auto-generated method stub
		
	}
}
