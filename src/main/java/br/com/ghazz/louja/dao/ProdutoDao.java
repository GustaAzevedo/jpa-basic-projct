package br.com.ghazz.louja.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.ghazz.louja.modelo.Pedido;
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
		String jpql = "SELECT p FROM Produto as p where p.categoria.id.nome = :name";
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
	
	public List<Produto> searchByParameters(String nome, BigDecimal preco, LocalDate dataCadastro){
		String jpql = "SELECT * FROM Produto p WHERE 1=1";

		if(nome != null && !nome.trim().isEmpty()) {
			jpql += " AND p.name = :nome ";
		}
		if(preco != null) {
			jpql += " AND p.price = :preco";
		}
		if(dataCadastro != null) {
			jpql += " AND p.dataCadastro = :dataCadastro";
		}
		
		TypedQuery<Produto> query = em.createQuery(jpql, Produto.class);
		
		if(nome != null && !nome.trim().isEmpty()) {
			query.setParameter("nome", nome);
		}
		if(preco != null) {
			query.setParameter("preco", preco);
		}
		if(dataCadastro != null) {
			query.setParameter("dataCadastro", dataCadastro);
		}
		
		return query.getResultList();		
		
	}
	
	public List<Produto> searchByParametersWithCriteria(String nome, BigDecimal preco, LocalDate dataCadastro){
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
		Root<Produto> from = query.from(Produto.class);
		
		Predicate filtro = builder.and();
		
		if(nome != null && !nome.trim().isEmpty()) {
			filtro = builder.and(filtro, builder.equal(from.get("name"), nome));
		}
		if(preco != null) {
			filtro = builder.and(filtro, builder.equal(from.get("price"), preco));
		}
		if(dataCadastro != null) {
			filtro = builder.and(filtro, builder.equal(from.get("dataCadastro"), dataCadastro));
		}
		
		query.where(filtro);
		return em.createQuery(query).getResultList();
		
	}
	
}
