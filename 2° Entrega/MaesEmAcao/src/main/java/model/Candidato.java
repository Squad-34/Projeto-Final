package model;

public class Candidato {

	private int idCandidato;
	private String nome;
	private String email;
	private String cpf;
	private String telefone;
	private String idioma;
	private String formacao;

	public Candidato() {
	}

	public Candidato(String nome, String email, String cpf, String telefone, String idioma, String formacao) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
		this.idioma = idioma;
		this.formacao = formacao;
	}

	public Candidato(int idCandidato, String nome, String email, String cpf, String telefone, String idioma,
			String formacao) {
		this.idCandidato = idCandidato;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
		this.idioma = idioma;
		this.formacao = formacao;
	}

	public int getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(int idCandidato) {
		this.idCandidato = idCandidato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public String toString() {
		return "Candidato [idCandidato=" + idCandidato + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf
				+ ", telefone=" + telefone + ", idioma=" + idioma + ", formacao=" + formacao + "]";
	}

}
