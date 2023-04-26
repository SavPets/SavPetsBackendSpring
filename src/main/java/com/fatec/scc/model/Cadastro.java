package com.fatec.scc.model;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cadastro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "Nome é requerido")
	private String nome;

	@NotBlank(message = "Sobrenome é requerido")
	private String sobrenome;
	
	@NotBlank(message = "Email é requerido")
	private String email;

	@NotBlank(message = "A senha é obrigatória")
	private String senha;
	
	@NotBlank(message = "Repetir a senha é obrigatório")
	private String repetirSenha;

	// Construtores
	public Cadastro() {	}

	public Cadastro(String nome, String sobrenome, String email, String senha, String repetirSenha) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.repetirSenha = repetirSenha;
	}

	// Getters e Setters
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

	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRepetirSenha() {
		return repetirSenha;
	}
	public void setRepetirSenha(String repetirSenha) {
		this.repetirSenha = repetirSenha;
	}
}
