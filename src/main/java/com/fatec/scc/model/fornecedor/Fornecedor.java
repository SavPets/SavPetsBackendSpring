package com.fatec.scc.model.fornecedor;


import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;
//The JPA was renamed as Jakarta Persistence in 2019 and version 3.0 was released in 2020. This included the renaming of packages and properties
//from javax. persistence to jakarta. persistence.
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fornecedor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "Nome é requerido")
	private String nome;
	@CNPJ
	@Column(unique = true)
	private String cnpj;
	@NotBlank(message = "O CEP é obrigatório.")
	private String cep;
	private String endereco;
	@NotBlank(message = "O complemento deve ser informado")
	private String complemento;

	public Fornecedor() {
		
	}
	
	public Fornecedor(String nome, String cnpj, String cep, String complemento) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.cep = cep;
		this.complemento = complemento;
	}
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Fornecedor retornaUmFornecedor() {
		return new Fornecedor(nome, cnpj, cep, complemento);
	}
}