package com.fatec.scc.model.adoption;

import javax.validation.constraints.NotBlank;

public class AdoptionDTO {
	private String employee;
	private String client;
	@NotBlank(message = "Categoria é requerido")
	private String animalCategory;
	@NotBlank(message = "A data da Adoção é obrigatoria")
	private String adoptionDate;
	@NotBlank(message = "O relatorio da Adoção é necessaria.")
	private String report;

	//========================Contrunctors=====================
	
	public AdoptionDTO() {
		
	}
	
	public AdoptionDTO(String employee,String client, String animalCategory,
			String adoptionDate,String report) {
		
		this.employee = employee;
		this.client= client;
		this.animalCategory= animalCategory;
		this.adoptionDate= adoptionDate;
		this.report= report;
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
	
	public Adoption retornoUmaAdocao() {
		return new Adoption(employee,client,animalCategory,adoptionDate,report);
	}
}
