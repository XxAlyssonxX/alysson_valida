package com.projetodrograria.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity  
@Table(name = "Drograria") 
public class Drograria { 

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id; 
	
	@NotNull(message = "nome é obrigatório")
	@NotBlank(message = "nome é obrigatório")
	@Column(name = "nome") 
	private String nome; 

	@NotNull(message = "cnpj é obrigatório")
	@NotBlank(message = "cnpj é obrigatório")
	@Column(name = "cnpj") 
	private String cnpj; 

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

	public String getCnpj() { 
		return cnpj; 
	}

	public void setCnpj(String cnpj) { 
		this.cnpj = cnpj; 
	} 

}
