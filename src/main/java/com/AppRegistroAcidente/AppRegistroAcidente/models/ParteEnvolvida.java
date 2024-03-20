package com.AppRegistroAcidente.AppRegistroAcidente.models;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

@Entity
public class ParteEnvolvida {
	
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
