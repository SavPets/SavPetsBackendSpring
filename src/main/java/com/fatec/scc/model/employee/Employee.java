package com.fatec.scc.model.employee;

import javax.validation.constraints.NotBlank;

import com.fatec.scc.model.Register;

import org.hibernate.validator.constraints.br.CPF;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Employee extends Register {
	@CPF
	@Column(unique = true)
	@NotBlank(message = "O CPF é obrigatório.")
	private String cpf;
	@NotBlank(message = "O CEP é obrigatório.")
	private String cep;
	private String address;
	@NotBlank(message = "O complemento deve ser informado")
	private String complement;
	@NotBlank(message = "O número da conta deve ser informado")
	private String accountNumber;
	private String departament;
	private String occupation;

	//Construtores
	public Employee() {	}
	
	public Employee(String cpf, String cep, String address, String complement, String accountNumber, String departament, String occupation) {
		this.cpf = cpf;
		this.cep = cep;
		this.address = address;
		this.complement = complement;
		this.accountNumber = accountNumber;
		this.departament = departament;
		this.occupation = occupation;
	}

	public Employee(String name, String surname, String email, String password, String repeatPassword, String cpf, String cep, String address, String complement, String accountNumber, String departament, String occupation) {
		super(name, surname, email, password, repeatPassword);
		this.cpf = cpf;
		this.cep = cep;
		this.address = address;
		this.complement = complement;
		this.accountNumber = accountNumber;
		this.departament = departament;
		this.occupation = occupation;
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

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getDepartament() {
		return departament;
	}
	public void setDepartament(String departament) {
		this.departament = departament;
	}
	
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Employee returnEmployee() {
		return new Employee(cpf, cep, address, complement, accountNumber, departament, occupation);
	}
}