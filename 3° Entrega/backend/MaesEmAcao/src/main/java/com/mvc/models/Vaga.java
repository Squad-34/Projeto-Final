package com.mvc.models;

import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "vagas")
public class Vaga extends Entidade {

	@Column(nullable = false, length = 80, unique = true)
	private String título;

	@Column(nullable = false, length = 80, unique = true)
	private String descrição;

	@Column(nullable = false, length = 80, unique = true)
	private String requisitos;

	@Column(nullable = false)
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private BigDecimal salario;

	public Vaga() {
		super();
	}

	public Vaga(String título, String descrição, String requisitos, BigDecimal salario) {
		super();
		this.título = título;
		this.descrição = descrição;
		this.requisitos = requisitos;
		this.salario = salario;
	}

	public String getTítulo() {
		return título;
	}

	public void setTítulo(String título) {
		this.título = título;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
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

}
