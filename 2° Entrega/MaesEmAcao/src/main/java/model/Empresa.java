package model;

public class Empresa {

	private int idEmpresa;
	private String nome;
	private String cnpj;
	private String email;
	private String telefone;
	private Endereco endereco;

	public Empresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
	public Empresa()

	public Empresa(String nome, String cnpj, String email, String telefone, Endereco endereco) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Empresa(int idEmpresa, String nome, String cnpj, String email, String telefone, Endereco endereco) {
		this.idEmpresa = idEmpresa;
		this.nome = nome;
		this.cnpj = cnpj;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Empresa [idEmpresa=" + idEmpresa + ", nome=" + nome + ", cnpj=" + cnpj + ", email=" + email
				+ ", telefone=" + telefone + ", endereco=" + endereco.getIdEndereco() + "]";
	}

}
