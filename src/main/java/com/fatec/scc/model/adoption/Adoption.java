package com.fatec.scc.model.adoption;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Adoption {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "O nome do animal é requerido")
	private String employee;
	private String client;
	@NotBlank(message = "Categoria é requerido")
	private String animalCategory;
	@NotBlank(message = "A data da Adoção é obrigatoria")
	private String adoptionDate;
	@NotBlank(message = "O relatorio da Adoção é necessaria.")
	private String report;

	//========================Contrunctors=====================
	
	public Adoption() {
		
	}
	
	public Adoption(String employee,String client, String animalCategory,
			String adoptionDate,String report) {
		this.employee = employee;
		this.client= client;
		this.animalCategory= animalCategory;
		this.adoptionDate= adoptionDate;
		this.report= report;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getAnimalCategory() {
		return animalCategory;
	}

	public void setAnimalCategory(String animalCategory) {
		this.animalCategory = animalCategory;
	}

	public String getAdoptionDate() {
		return adoptionDate;
	}

	public void setAdoptionDate(String adoptionDate) {
		this.adoptionDate = adoptionDate;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}
}
