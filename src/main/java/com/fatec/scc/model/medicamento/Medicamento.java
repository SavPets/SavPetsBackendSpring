package com.fatec.scc.model.medicamento;

import javax.validation.constraints.NotBlank;

import com.fatec.scc.model.fornecedor.Fornecedor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Medicamento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "Fornecedor requerido")
	private String fornecedor;
	private String nomeMedicamento;
	private String descricao;
	private Integer bula;
	private String utilidade;
	private String dataValidade;
	private String observacao;
	private String dataChegada;
	private Integer quantidade;
	private String dataFabricacao;
	
	
	
	
	
	public Medicamento() {
		
	}

	public Medicamento(String fornecedor, String nomeMecicamento, String descricao, Integer bula,
			String utilidade, String dataValidade, String observacao, String dataChegada, Integer quantidade, String dataFabricacao) {
		this.fornecedor = fornecedor;
		this.nomeMedicamento = nomeMecicamento;
		this.descricao = descricao;
		this.bula = bula;
		this.utilidade = utilidade;
		this.dataValidade = dataValidade;
		this.observacao = observacao;
		this.dataChegada = dataChegada;
		this.quantidade = quantidade;
		this.dataFabricacao = dataFabricacao;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public String getNomeMedicamento() {
		return nomeMedicamento;
	}
	public void setNomeMedicamento(String nomeMecicamento) {
		this.nomeMedicamento = nomeMecicamento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getBula() {
		return bula;
	}
	public void setBula(Integer bula) {
		this.bula = bula;
	}
	public String getUtilidade() {
		return utilidade;
	}
	public void setUtilidade(String utilidade) {
		this.utilidade = utilidade;
	}
	public String getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getDataChegada() {
		return dataChegada;
	}
	public void setDataChegada(String dataChegada) {
		this.dataChegada = dataChegada;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public String getDataFabricacao() {
		return dataFabricacao;
	}
	public void setDataFabricacao(String dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	public Medicamento retornaUmMedicamento() {
		return new Medicamento(fornecedor, nomeMedicamento, descricao, bula, utilidade, dataValidade, observacao, dataChegada, quantidade, dataFabricacao);
	}
	
	
}
