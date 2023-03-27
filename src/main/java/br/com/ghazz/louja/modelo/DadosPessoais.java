package br.com.ghazz.louja.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DadosPessoais implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1872383799068853633L;

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
