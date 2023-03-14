package br.com.ghazz.louja.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.ghazz.louja.modelo.Pedido;
import br.com.ghazz.louja.vo.OrderTotalReportVo;

public class PedidoDao {

	private EntityManager em;

	public PedidoDao(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void save(Pedido pedido) {
		this.em.persist(pedido);
	}
	
	public void update(Pedido pedido) {
		this.em.persist(pedido);
	}
	
	public void delete(Pedido pedido) {
		pedido = em.merge(pedido);
		this.em.remove(pedido);;
	}
	
	public Pedido searchById(Long id) {
		return em.find(Pedido.class, id);
	}
	
	public BigDecimal totalOrderAmount() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return em.createQuery(jpql, BigDecimal.class)
				.getSingleResult();
	}
	
	public List<OrderTotalReportVo> salesReport(){
		String jpql = "SELECT New br.com.ghazz.louja.vo.OrderTotalReportVo("
				+ "produto.name, SUM(item.quantity), MAX(pedido.data)) "
				+ "FROM Pedido AS pedido "
				+ "INNER JOIN pedido.intesPedido AS item "
				+ "INNER JOIN item.produto AS produto "
				+ "GROUP BY produto.name ";
		return em.createQuery(jpql, OrderTotalReportVo.class).getResultList();
	}
	
	public Pedido searchByIdWithCliente(Long id) {
		String jpql = "SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :id";
		return em.createQuery(jpql, Pedido.class)
				.setParameter("id", id)
				.getSingleResult();
	}
	
	public List<Pedido> searchByParameters(String nome, BigDecimal preco, LocalDate dataCadastro){
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
		
		TypedQuery<Pedido> query = em.createQuery(jpql, Pedido.class);
		
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
} 
