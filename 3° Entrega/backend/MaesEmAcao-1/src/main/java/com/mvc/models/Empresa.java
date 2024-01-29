package com.mvc.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresas")
public class Empresa extends Entidade {

	@Column(nullable = false, length = 80)
	private String nome;

	@Column(nullable = false, length = 14, unique = true)
	private String cnpj;

	@Column(nullable = false, length = 15)
	private String telefone;

	@Column(nullable = false, length = 80, unique = true)
	private String email;

	@Column(name = "endereco", nullable = false)
	private String endereco;

	@OneToMany(mappedBy = "empresa", orphanRemoval = true)
	private List<Vaga> vagas = new ArrayList<>();

	public Empresa() {
		super();
	}


	public Empresa(String nome, String cnpj, String telefone, String email, String endereco, List<Vaga> vagas) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.vagas = vagas;
	}

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCnpj() {
		return cnpj;
	}



	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	public List<Vaga> getVagas() {
		return vagas;
	}



	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}



	public void addVaga(Vaga vaga) {
		vagas.add(vaga);
		vaga.setEmpresa(this);
	}

	public void removerVaga(Vaga vaga) {
		vagas.remove(vaga);
		vaga.setEmpresa(this);
	}


}
