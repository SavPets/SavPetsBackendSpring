package com.fatec.scc.model.medicine;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "Fornecedor requerido")
	private String provider;
	private String medicineName;
	private String description;
	private Integer leaflet;
	private String utility;
	private String expirationDate;
	private String observation;
	private String arrivalDate;
	private Integer amount;
	private String manufacturingDate;
	
	
	
	
	
	public Medicine() {
		
	}

	public Medicine(String provider, String nomeMecicamento, String description, Integer leaflet,
					String utility, String expirationDate, String observation, String arrivalDate, Integer amount, String manufacturingDate) {
		this.provider = provider;
		this.medicineName = nomeMecicamento;
		this.description = description;
		this.leaflet = leaflet;
		this.utility = utility;
		this.expirationDate = expirationDate;
		this.observation = observation;
		this.arrivalDate = arrivalDate;
		this.amount = amount;
		this.manufacturingDate = manufacturingDate;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String nomeMecicamento) {
		this.medicineName = nomeMecicamento;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getLeaflet() {
		return leaflet;
	}
	public void setLeaflet(Integer leaflet) {
		this.leaflet = leaflet;
	}
	public String getUtility() {
		return utility;
	}
	public void setUtility(String utility) {
		this.utility = utility;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getManufacturingDate() {
		return manufacturingDate;
	}
	public void setManufacturingDate(String manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	public Medicine returnMedicine() {
		return new Medicine(provider, medicineName, description, leaflet, utility, expirationDate, observation, arrivalDate, amount, manufacturingDate);
	}
	
	
}
