package com.projetodrograria.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity  
@Table(name = "Medicamento") 
public class Medicamento { 

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id; 
	
	@NotNull(message = "nome é obrigatório")
	@NotBlank(message = "nome é obrigatório")
	@Column(name = "nome") 
	private String nome; 

	@NotNull(message = "bula é obrigatório")
	@NotBlank(message = "bula é obrigatório")
	@Column(name = "bula") 
	private String bula; 
	
	@NotNull(message = "data é obrigatório")
	@NotBlank(message = "data é obrigatório")
	@Column(name = "data") 
	private String data;
	

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

	public String getBula() { 
		return bula; 
	}

	public void setBula(String bula) { 
		this.bula = bula; 
	} 

	public String getData() { 
		return data; 
	} 

	public void setData(String data) { 
		this.data = data; 
	} 

}
