package br.com.ghazz.louja.dao;

import java.math.BigDecimal;
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
	
	public List<Produto> searchByName(String name){
		String jpql = "SELECT p FROM Produto as p where p.name = :name";
		return em.createQuery(jpql, Produto.class)
				.setParameter("name", name)
				.getResultList();
	}
	
	public List<Produto> searchByCategoriaNome(String categoryName){
		String jpql = "SELECT p FROM Produto as p where p.categoria.nome = :name";
		return em.createQuery(jpql, Produto.class)
				.setParameter("name", categoryName)
				.getResultList();
	}
	
	public BigDecimal searchProductPriceByName(String name){
		String jpql = "SELECT p.price FROM Produto as p where p.name = :nome";
		return em.createQuery(jpql, BigDecimal.class)
				.setParameter("nome", name)
				.getSingleResult();
	}
}
