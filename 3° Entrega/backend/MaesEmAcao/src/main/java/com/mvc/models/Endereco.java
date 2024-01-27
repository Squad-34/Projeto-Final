package com.mvc.models;

import com.mvc.enums.UF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Endereco extends Entidade {

	@Column(nullable = false, length = 2)
	@Enumerated(EnumType.STRING)
	private UF uf;

	@Column(nullable = false)
	private String cidade;

	@Column(nullable = false)
	private String bairro;

	@Column(nullable = false)
	private String logradouro;

	@Column(nullable = false)
	private String cep;

	@Column(nullable = false)
	private String numero;

	@Column(nullable = false)
	private String complemento;

	@ManyToOne(optional = false)
	@JoinColumn(name = "fk_empresa")
	private Empresa empresa;

	public Endereco() {
	}

	public Endereco(UF uf, String cidade, String bairro, String logradouro, String cep, String numero,
			String complemento, Empresa empresa) {
		this.uf = uf;
		this.cidade = cidade;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.complemento = complemento;
		this.empresa = empresa;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		StringBuilder enderecoCompleto = new StringBuilder();
		enderecoCompleto.append(logradouro).append(", n° ").append(numero).append(", ").append(complemento)
				.append(" - ").append(bairro).append(". ").append(uf.getDescricao()).append(" - ").append(cidade)
				.append(". CEP: ").append(cep);

		return enderecoCompleto.toString();
	}

}
