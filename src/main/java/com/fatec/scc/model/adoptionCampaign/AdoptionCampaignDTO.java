package com.fatec.scc.model.adoptionCampaign;

import javax.validation.constraints.NotBlank;

public class AdoptionCampaignDTO {
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
	
	public AdoptionCampaignDTO() {	}


	public AdoptionCampaignDTO(String name, String description, String date, String time, String duration, String location) {
		this.name = name;
		this.description = description;
		this.date = date;
		this.time = time;
		this.duration = duration;
		this.location = location;
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
	
	public AdoptionCampaign returnAdoptionCampaign() {
		return new AdoptionCampaign(name, description, date, time, duration, location);
	}
}
