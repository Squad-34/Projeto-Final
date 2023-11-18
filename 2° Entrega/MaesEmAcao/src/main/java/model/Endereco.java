package model;

public class Endereco {

	private int idEndereco;
	private int cep;
	private String estado;
	private String cidade;
	private Candidato candidato;

	public Endereco() {
	}

	public Endereco(int cep, String estado, String cidade, Candidato candidato) {
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.candidato = candidato;
	}

	public Endereco(int idEndereco, int cep, String estado, String cidade, Candidato candidato) {
		this.idEndereco = idEndereco;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.candidato = candidato;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	@Override
	public String toString() {
		return "Endereco [idEndereco=" + idEndereco + ", cep=" + cep + ", estado=" + estado + ", cidade=" + cidade
				+ ", candidato=" + candidato.getIdCandidato() + "]";
	}

}
