package com.mvc.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidatos")
public class Candidato extends Entidade {

	@Column(nullable = false, length = 80)
	private String nome;

	@Column(nullable = false, length = 14, unique = true)
	private String cpf;

	@Column(nullable = false, length = 15)
	private String telefone;
	
	@Column(nullable = false)
	private int qtdFilhos;

	@Column(nullable = false, length = 80, unique = true)
	private String email;
	
	@Column(nullable = false, length = 80)
	private String idioma;
	
	@Column(nullable = false, length = 80)
	private String formação;

	@Column(name = "data_nascimento", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNascimento;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "endereco_fk", nullable = false)
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name = "experiencia_fk", nullable = false)
	private Experiencia experiencia;

	public Candidato() {
		super();
	}


	public Candidato(String nome, String cpf, String telefone, int qtdFilhos, String email, String idioma,
			String formação, LocalDate dataNascimento, Endereco endereco, Experiencia experiencia) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.qtdFilhos = qtdFilhos;
		this.email = email;
		this.idioma = idioma;
		this.formação = formação;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.experiencia = experiencia;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public int getQtdFilhos() {
		return qtdFilhos;
	}

	public void setQtdFilhos(int qtdFilhos) {
		this.qtdFilhos = qtdFilhos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getFormação() {
		return formação;
	}

	public void setFormação(String formação) {
		this.formação = formação;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Experiencia getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Experiencia experiencia) {
		this.experiencia = experiencia;
	}
	
}
