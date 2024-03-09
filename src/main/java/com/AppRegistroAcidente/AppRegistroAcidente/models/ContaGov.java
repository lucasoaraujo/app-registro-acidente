package com.AppRegistroAcidente.AppRegistroAcidente.models;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Size;

@Entity
public class ContaGov {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(unique = true)
	@NotNull
	@Size(max = 50)
    private String usuario;
	
	@NotNull
    @Size(min = 6, max = 12, message = "A senha deve ter entre 6 e 12 caracteres, "
    + "incluindo letras maiúsculas e minúsculas, números e caracteres especiais.")
	private String senha;
    
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Cidadao getCidadao() {
		return cidadao;
	}

	public void setCidadao(Cidadao cidadao) {
		this.cidadao = cidadao;
	}
    
	@OneToOne(mappedBy = "contaGov")
	private Cidadao cidadao; // Esta é a propriedade ausente

}
