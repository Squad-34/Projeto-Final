package com.mvc.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "experiencias")
public class Experiencia extends Entidade {

	@Column(nullable = false, length = 15)
	private String nomeEmpresa;

	@Column(nullable = false, length = 15)
	private String cargo;

	@Column(name = "data_inicio", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataInicio;

	@Column(name = "data_fim")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataFim;
	
	@ManyToOne
	private Candidato candidato;

	public Experiencia() {
		super();
	}

	public Experiencia(String nomeEmpresa, String cargo, LocalDate dataInicio, LocalDate dataFim, Candidato candidato) {
		super();
		this.nomeEmpresa = nomeEmpresa;
		this.cargo = cargo;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.candidato = candidato;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}


}
