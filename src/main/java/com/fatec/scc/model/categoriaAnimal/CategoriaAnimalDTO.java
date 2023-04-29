package com.fatec.scc.model.categoriaAnimal;

import javax.validation.constraints.NotBlank;

public class CategoriaAnimalDTO {

	@NotBlank(message = "Nome da categoria é requerido")
	private String nome;

	@NotBlank(message = "Nome da raça é obrigatória")
	private String raca;

	@NotBlank(message = "Sexo M/F")
	private String sexo;

	@NotBlank(message = "O porte é obrigatório.")
	private String porte;

	@NotBlank(message = "A cor da pelagem deve ser informada")
	private String corPelagem;

	public CategoriaAnimalDTO (String nome, String raca, String sexo, String porte, String corPelagem) {
		this.nome = nome;
		this.raca = raca;
		this.sexo = sexo;
		this.porte = porte;
		this.corPelagem = corPelagem;
	}

	public CategoriaAnimalDTO() {
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public String getCorPelagem() {
		return corPelagem;
	}

	public void setCorPelagem(String corPelagem) {
		this.corPelagem = corPelagem;
	}

	public CategoriaAnimal retornaUmaCategoriaAnimal() {
		return new CategoriaAnimal(nome, raca, sexo, porte, corPelagem);
	}
}