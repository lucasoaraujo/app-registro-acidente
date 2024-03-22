package com.AppRegistroAcidente.AppRegistroAcidente.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ParteEnvolvida {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	    
	 @ManyToOne
	 private Veiculo veiculo;
	 private String tipoParticipacao;
	    
	 @ManyToOne
	 private Ocorrencia ocorrencia;
	
	 

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Veiculo getVeiculo() {
		return veiculo;
	}



	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}



	public String getTipoParticipacao() {
		return tipoParticipacao;
	}



	public void setTipoParticipacao(String tipoParticipacao) {
		this.tipoParticipacao = tipoParticipacao;
	}



	public Ocorrencia getOcorrencia() {
		return ocorrencia;
	}



	public void setOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
	
	@ManyToOne
	private Cidadao cidadao;

	public Cidadao getCidadao() {
	    return cidadao;
	}

	public void setCidadao(Cidadao cidadao) {
	    this.cidadao = cidadao;
	}

}
