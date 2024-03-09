
   package com.AppRegistroAcidente.AppRegistroAcidente.models;

import java.util.List;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    private byte[] fotos;
    
    @NotNull
	@Size(max = 15)
    private String situacao;
    
    @NotNull
    @Lob
    private byte[] boletimOcorrencia;
    
    @NotNull
	@Size(max = 15)
    private String codigoConfirmacao; // Novo atributo
    
    @NotNull
	@Size(max = 15)
    private String statusConfirmacao; // Novo atributo
    
    @OneToMany(mappedBy = "ocorrencia")
    private List<ParteEnvolvida> partesEnvolvidas;
    
    @ManyToOne
    private Cidadao cidadao;

    // Getters e Setters

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

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public byte[] getFotos() {
		return fotos;
	}

	public void setFotos(byte[] fotos) {
		this.fotos = fotos;
	}

	public byte[] getBoletimOcorrencia() {
		return boletimOcorrencia;
	}

	public void setBoletimOcorrencia(byte[] boletimOcorrencia) {
		this.boletimOcorrencia = boletimOcorrencia;
	}

	public String getCodigoConfirmacao() {
        return codigoConfirmacao;
    }

    public void setCodigoConfirmacao(String codigoConfirmacao) {
        this.codigoConfirmacao = codigoConfirmacao;
    }

    public String getStatusConfirmacao() {
        return statusConfirmacao;
    }

    public void setStatusConfirmacao(String statusConfirmacao) {
        this.statusConfirmacao = statusConfirmacao;
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
}
