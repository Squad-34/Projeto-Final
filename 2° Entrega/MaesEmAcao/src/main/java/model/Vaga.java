package model;

public class Vaga {
	private int idVaga;
	private String titulo;
	private String descricao;
	private String requisito;
	private Double salario;
	private Empresa empresa;

	public Vaga() {
	}

	public Vaga(String titulo, String descricao, String requisito, Double salario, Empresa empresa) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.requisito = requisito;
		this.salario = salario;
		this.empresa = empresa;
	}

	public Vaga(int idVaga, String titulo, String descricao, String requisito, Double salario, Empresa empresa) {
		this.idVaga = idVaga;
		this.titulo = titulo;
		this.descricao = descricao;
		this.requisito = requisito;
		this.salario = salario;
		this.empresa = empresa;
	}

	public int getIdVaga() {
		return idVaga;
	}

	public void setIdVaga(int idVaga) {
		this.idVaga = idVaga;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getRequisito() {
		return requisito;
	}

	public void setRequisito(String requisito) {
		this.requisito = requisito;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "Vaga [idVaga=" + idVaga + ", titulo=" + titulo + ", descricao=" + descricao + ", requisito=" + requisito
				+ ", salario=" + salario + ", empresa=" + empresa.getIdEmpresa() + "]";
	}

}
