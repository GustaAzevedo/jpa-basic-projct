package br.com.ghazz.louja.dao;

import javax.persistence.EntityManager;

import br.com.ghazz.louja.modelo.Categoria;

public class CategoriaDao {

	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void save(Categoria categoria) {
		this.em.persist(categoria);
	}
	
	public void update(Categoria categoria) {
		this.em.merge(categoria);
	}
	
	public void delete(Categoria categoria) {
		categoria = em.merge(categoria);
		this.em.remove(categoria);;
	}
	
}
