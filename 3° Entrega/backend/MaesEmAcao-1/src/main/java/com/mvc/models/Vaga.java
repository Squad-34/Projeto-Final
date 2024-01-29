package com.mvc.models;

import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

	@ManyToOne(optional = false)
	@JoinColumn(name = "fk_empresa")
	private Empresa empresa;

	public Vaga() {
		super();
	}

	public Vaga(String titulo, String descricao, String requisitos, BigDecimal salario, Empresa empresa) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.requisitos = requisitos;
		this.salario = salario;
		this.empresa = empresa;
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
