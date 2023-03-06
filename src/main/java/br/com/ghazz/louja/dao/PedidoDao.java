package br.com.ghazz.louja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

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
	
	public Pedido searchById(Pedido id) {
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
}
