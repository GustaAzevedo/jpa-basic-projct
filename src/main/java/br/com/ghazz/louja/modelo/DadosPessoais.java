package br.com.ghazz.louja.modelo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DadosPessoais {
	
	@Column(name = "nome")
	private String name;
	
	@Column(name = "cpf")
	private String cpf;
	
	
	
	public DadosPessoais() {
		super();
	}

	public DadosPessoais(String name, String cpf) {
		super();
		this.name = name;
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
