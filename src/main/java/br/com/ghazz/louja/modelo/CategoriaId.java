package br.com.ghazz.louja.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CategoriaId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8699431793199497230L;
	@Column(name = "tipo")
	private String type;
	@Column(name = "nome")
	private String name;
	
	public CategoriaId() {
		super();
	}
	
	public CategoriaId(String type, String name) {
		super();
		this.type = type;
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
