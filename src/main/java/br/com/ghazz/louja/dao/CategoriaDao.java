package br.com.ghazz.louja.dao;

import javax.persistence.EntityManager;

import br.com.ghazz.louja.modelo.Categoria;

public class CategoriaDao {

	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void SaveCategoria(Categoria categoria) {
		em.persist(categoria);
	}
	

	
}
