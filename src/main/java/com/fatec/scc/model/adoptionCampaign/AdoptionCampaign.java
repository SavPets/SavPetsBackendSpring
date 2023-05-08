package com.fatec.scc.model.adoptionCampaign;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AdoptionCampaign {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "O nome da campanha é obrigatório")
	private String name;
	@NotBlank(message = "A descrição da campanha é obrigatória")
	private String description;
	@NotBlank(message = "A data da campanha é obrigatória")
	private String date;
	@NotBlank(message = "O horário da campanha é obrigatório")
	private String time;
	@NotBlank(message = "A duração da campanha é obrigatória")
	private String duration;
	@NotBlank(message = "O local da campanha é obrigatório")
	private String location;
	
	//@NotBlank(message = "O id do animal é obrigatório")
	//private Long animalId;
	//@NotBlank(message = "O nome do animal é obrigatório")
	//private String animalName;
	//@NotBlank(message = "A raça do animal é obrigatória")
	//private String animalRace;
	//@NotBlank(message = "A data de chegada do animal é obrigatória")
	//private String arrivalDate;
	
	public AdoptionCampaign() {	}


	public AdoptionCampaign(String name, String description, String date, String time, String duration, String location) {
		this.name = name;
		this.description = description;
		this.date = date;
		this.time = time;
		this.duration = duration;
		this.location = location;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
