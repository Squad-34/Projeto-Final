package model;

public class CandidatoEndereco {
	private Candidato candidato;
	private Endereco endereco;

	public CandidatoEndereco() {
	}

	public CandidatoEndereco(Candidato candidato, Endereco endereco) {
		this.candidato = candidato;
		this.endereco = endereco;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
