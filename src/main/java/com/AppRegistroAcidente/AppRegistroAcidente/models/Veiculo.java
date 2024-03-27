package com.AppRegistroAcidente.AppRegistroAcidente.models;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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

	@ManyToOne
	@JoinColumn(name = "ocorrencia_id")
	private Ocorrencia ocorrencia;
	
	// Métodos Getter e Setter para o atributo Ocorrencia
    public Ocorrencia getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(Ocorrencia ocorrencia) {
        this.ocorrencia = ocorrencia;
        if (ocorrencia != null) {
            if (ocorrencia.getVeiculos() == null) {
                ocorrencia.setVeiculos(new ArrayList<>());
            }
            ocorrencia.getVeiculos().add(this);
        }
    }

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
	
	
	
}
