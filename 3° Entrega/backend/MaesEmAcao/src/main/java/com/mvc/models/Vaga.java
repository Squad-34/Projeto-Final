package com.mvc.models;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "vagas")
public class Vaga extends Entidade {

	@Column(nullable = false, length = 80)
	private String titulo;

	@Column(nullable = false, length = 80)
	private String descricao;

	@Column(nullable = false, length = 80)
	private String requisitos;

	@Column(nullable = false)
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private BigDecimal salario;

	@OneToMany(mappedBy = "vaga", cascade = CascadeType.REMOVE)
	private List<Candidato> candidatos;

	@OneToMany(mappedBy = "vaga", cascade = CascadeType.REMOVE)
	private List<Empresa> empresas;

	public Vaga() {
		super();
	}

	public Vaga(String titulo, String descricao, String requisitos, BigDecimal salario, List<Candidato> candidatos,
			List<Empresa> empresas) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.requisitos = requisitos;
		this.salario = salario;
		this.candidatos = candidatos;
		this.empresas = empresas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String título) {
		this.titulo = título;
	}

	public String getDescricao() {
	    return descricao;
	}

	public void setDescricao(String descricao) {
	    this.descricao = descricao;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

}
