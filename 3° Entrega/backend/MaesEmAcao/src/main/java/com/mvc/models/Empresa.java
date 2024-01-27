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

	@OneToMany(mappedBy = "empresa", orphanRemoval = true)
	private List<Endereco> enderecos = new ArrayList<>();

	@OneToMany(mappedBy = "empresa", orphanRemoval = true)
	private List<Vaga> vagas = new ArrayList<>();

	public Empresa() {
		super();
	}

	public Empresa(String nome, String cnpj, String telefone, String email) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.email = email;
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

	public void addVaga(Vaga vaga) {
		vagas.add(vaga);
		vaga.setEmpresa(this);
	}

	public void removerVaga(Vaga vaga) {
		vagas.remove(vaga);
		vaga.setEmpresa(this);
	}

	public void addEndereco(Endereco endereco) {
		enderecos.add(endereco);
		endereco.setEmpresa(this);
	}

	public void removerEndereco(Endereco endereco) {
		enderecos.remove(endereco);
		endereco.setEmpresa(this);
	}

}
