package com.fatec.scc.model.adoptionCampaign;

import javax.validation.constraints.NotBlank;

public class AdoptionCampaignDTO {
	@NotBlank(message = "A data de da campanha é obrigatória")
	private String date;
	@NotBlank(message = "O local da campanha é obrigatório")
	private String location;
	@NotBlank(message = "A descrição da campanha é obrigatória")
	private String description;
	@NotBlank(message = "O id do animal é obrigatório")
	private Long animalId;
	@NotBlank(message = "O nome do animal é obrigatório")
	private String animalName;
	@NotBlank(message = "A raça do animal é obrigatória")
	private String animalRace;
	@NotBlank(message = "A data de chegada do animal é obrigatória")
	private String arrivalDate;
	
	public AdoptionCampaignDTO() {	}


	public AdoptionCampaignDTO(String date, String location, String description, Long animalId, String animalName, String animalRace, String arrivalDate) {
		this.date = date;
		this.location = location;
		this.description = description;
		this.animalId = animalId;
		this.animalName = animalName;
		this.animalRace = animalRace;
		this.arrivalDate = arrivalDate;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Long getAnimalId() {
		return animalId;
	}
	public void setAnimalId(Long id) {
		this.animalId = id;
	}
	
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public String getAnimalRace() {
		return animalRace;
	}
	public void setAnimalRace(String animalRace) {
		this.animalRace = animalRace;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	
	public AdoptionCampaign returnAdoptionCampaign() {
		return new AdoptionCampaign(date, location, description, animalId, animalName, animalRace, arrivalDate);
	}
}
