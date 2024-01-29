package com.mvc.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	private String formacao;

	@Column(name = "data_nascimento", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNascimento;

	@Column(name = "endereco", nullable = false)
	private String endereco;

	@OneToMany(mappedBy = "candidato", orphanRemoval = true)
	private List <Experiencia> experiencias = new ArrayList<>();
//	
//	@ManyToOne
//	private Vaga vaga;

	public Candidato() {
		super();
	}


	public Candidato(String nome, String cpf, String telefone, int qtdFilhos, String email, String idioma, String formacao,
		LocalDate dataNascimento, String endereco, List<Experiencia> experiencias) {
	super();
	this.nome = nome;
	this.cpf = cpf;
	this.telefone = telefone;
	this.qtdFilhos = qtdFilhos;
	this.email = email;
	this.idioma = idioma;
	this.formacao = formacao;
	this.dataNascimento = dataNascimento;
	this.endereco = endereco;
	this.experiencias = experiencias;
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
	

	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public void addExperiencia(Experiencia experiencia) {
		experiencias.add(experiencia);
		experiencia.setCandidato(this);
	}

	public void removerExperiencia(Experiencia experiencia) {
		experiencias.remove(experiencia);
		experiencia.setCandidato(null);
	}
	
	

}
