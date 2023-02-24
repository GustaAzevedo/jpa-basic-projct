package br.com.ghazz.louja.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.ghazz.louja.modelo.Produto;

public class ProdutoDao {

	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void save(Produto produto) {
		this.em.persist(produto);
	}
	
	public void update(Produto produto) {
		this.em.persist(produto);
	}
	
	public void delete(Produto produto) {
		produto = em.merge(produto);
		this.em.remove(produto);;
	}
	
	public Produto searchById(Long id) {
		return em.find(Produto.class, id);
	}
	
	public List<Produto> searchAll(){
		 String jpql = "SELECT p FROM Produto as p";
		 return em.createQuery(jpql, Produto.class).getResultList();
	}
}
