package br.com.ghazz.louja.dao;

import javax.persistence.EntityManager;

import br.com.ghazz.louja.modelo.Produto;

public class ProdutoDao {

	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void SaveProduct(Produto produto) {
		em.persist(produto);
	}
	

	
}
