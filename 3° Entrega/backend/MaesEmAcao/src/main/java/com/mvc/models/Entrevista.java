package com.mvc.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "entrevistas")
public class Entrevista extends Entidade {

	@ManyToOne
	@JoinColumn(name = "candidato_fk", nullable = false)
	private Candidato candidato;

	@ManyToOne
	@JoinColumn(name = "vaga_fk", nullable = false)
	private Vaga vaga;

	@Column(name = "data_entrevista", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate data;

	@Column(nullable = false, length = 80)
	private String local;

	@Column(nullable = false, length = 15)
	private String resultado;

	public Entrevista() {
		super();
	}

	public Entrevista(Candidato candidato, Vaga vaga, LocalDate data, String local, String resultado) {
		super();
		this.candidato = candidato;
		this.vaga = vaga;
		this.data = data;
		this.local = local;
		this.resultado = resultado;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
}
