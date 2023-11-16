package model;

import java.time.LocalDate;

public class Experiencia {
	private int idExperiencia;
	private String nomeEmpresa;
	private String cargo;
	private LocalDate dataInicio;
	private LocalDate dataFinal;
	private Candidato candidato;

	public Experiencia() {
	}

	public Experiencia(String nomeEmpresa, String cargo, LocalDate dataInicio, LocalDate dataFinal,
			Candidato candidato) {
		this.nomeEmpresa = nomeEmpresa;
		this.cargo = cargo;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.candidato = candidato;
	}

	public Experiencia(int idExperiencia, String nomeEmpresa, String cargo, LocalDate dataInicio, LocalDate dataFinal,
			Candidato candidato) {
		this.idExperiencia = idExperiencia;
		this.nomeEmpresa = nomeEmpresa;
		this.cargo = cargo;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.candidato = candidato;
	}

	public int getIdExperiencia() {
		return idExperiencia;
	}

	public void setIdExperiencia(int idExperiencia) {
		this.idExperiencia = idExperiencia;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	@Override
	public String toString() {
		return "Experiencia [idExperiencia=" + idExperiencia + ", nomeEmpresa=" + nomeEmpresa + ", cargo=" + cargo
				+ ", dataInicio=" + dataInicio + ", dataFinal=" + dataFinal + ", candidato="
				+ candidato.getIdCandidato() + "]";
	}

}
