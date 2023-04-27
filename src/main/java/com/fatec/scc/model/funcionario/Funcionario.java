package com.fatec.scc.model.funcionario;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;
import com.fatec.scc.model.Cadastro;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Funcionario extends Cadastro {
	@CPF
	@Column(unique = true)
	@NotBlank(message = "O CPF é obrigatório.")
	private String cpf;
	@NotBlank(message = "O CEP é obrigatório.")
	private String cep;
	private String endereco;
	@NotBlank(message = "O complemento deve ser informado")
	private String complemento;
	@NotBlank(message = "O número da conta deve ser informado")
	private String numeroConta;
	//private Departamento departamento;
	//private Cargo cargo;

	//Construtores
	public Funcionario() {	}
	
	public Funcionario(String cpf, String cep, String endereco, String complemento, String numeroConta) {
		this.cpf = cpf;
		this.cep = cep;
		this.endereco = endereco;
		this.complemento = complemento;
		this.numeroConta = numeroConta;
	}

	public Funcionario(String nome, String sobrenome, String email, String senha, String repetirSenha, String cpf, String cep, String endereco, String complemento, String numeroConta) {
		super(nome, sobrenome, email, senha, repetirSenha);
		this.cpf = cpf;
		this.cep = cep;
		this.endereco = endereco;
		this.complemento = complemento;
		this.numeroConta = numeroConta;
	}
	
	//Getters e Setters
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Funcionario retornaUmFuncionario() {
		return new Funcionario(cpf, cep, endereco, complemento, numeroConta);
	}
}