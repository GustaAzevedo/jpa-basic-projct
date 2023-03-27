package br.com.ghazz.louja.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
	
	@EmbeddedId
	private CategoriaId id;
	
	public Categoria() {
		super();
	}
	
	public Categoria(String name) {
		super();
		this.id = new CategoriaId("Xtreme",name);
	}

	public String getName() {
		return this.id.getName();
	}
	
	
}
