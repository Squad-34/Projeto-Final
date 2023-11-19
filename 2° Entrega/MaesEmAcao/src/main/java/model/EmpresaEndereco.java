package model;

public class EmpresaEndereco {
	private Endereco endereco;
	private Empresa empresa;
	
	public EmpresaEndereco() {
		super();
	}

	public EmpresaEndereco(Endereco endereco, Empresa empresa) {
		this.endereco = endereco;
		this.empresa = empresa;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
