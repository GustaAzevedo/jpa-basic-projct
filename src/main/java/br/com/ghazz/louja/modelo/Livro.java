package br.com.ghazz.louja.modelo;

import javax.persistence.Entity;

@Entity
public class Livro extends Produto {
	
	private String autor;
	private Integer numPaginas;
	
	
	public Livro() {
		super();
	}
	
	
	public Livro(String autor, Integer numPaginas) {
		super();
		this.autor = autor;
		this.numPaginas = numPaginas;
	}


	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Integer getNumPaginas() {
		return numPaginas;
	}
	public void setNumPaginas(Integer numPaginas) {
		this.numPaginas = numPaginas;
	}
	
	
}
