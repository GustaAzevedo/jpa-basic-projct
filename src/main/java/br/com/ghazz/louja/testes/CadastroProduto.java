package br.com.ghazz.louja.testes;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ghazz.louja.dao.CategoriaDao;
import br.com.ghazz.louja.dao.ClienteDao;
import br.com.ghazz.louja.dao.PedidoDao;
import br.com.ghazz.louja.dao.ProdutoDao;
import br.com.ghazz.louja.modelo.Categoria;
import br.com.ghazz.louja.modelo.Cliente;
import br.com.ghazz.louja.modelo.ItemPedido;
import br.com.ghazz.louja.modelo.Pedido;
import br.com.ghazz.louja.modelo.Produto;
import br.com.ghazz.louja.util.JPAUtil;
import br.com.ghazz.louja.vo.OrderTotalReportVo;

public class CadastroProduto {

	public static void main(String[] args) {
		/*
		Cliente cliente = new Cliente("Yuri", "65419886444");
		
		Pedido pedido = new Pedido(cliente);
		
		Categoria categoria = new Categoria("Smartwatch Xiaomi");
		
		Produto produto = new Produto("Xiaomi watch 3", "The best smartwatch IOS", new BigDecimal("11000.08"), categoria);
		
		ItemPedido itemPedido = new ItemPedido(pedido, produto, 3);
		pedido.adicionaItemPedido(itemPedido);
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		ClienteDao clienteDao = new ClienteDao(em);	
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		clienteDao.save(cliente);
		categoriaDao.save(categoria);
		
		em.getTransaction().commit();
		cliente = em.merge(cliente);
		categoria = em.merge(categoria);
		
		em.getTransaction().begin();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		PedidoDao pedidoDao = new PedidoDao(em);
		
		produtoDao.save(produto);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		pedidoDao.save(pedido);
		em.getTransaction().commit();
		
		BigDecimal totalValorPedidoVendido = pedidoDao.totalOrderAmount();
		System.out.println("Total vendido: " + totalValorPedidoVendido);
		*/
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		PedidoDao pedidoDao = new PedidoDao(em);
		Pedido pedido = pedidoDao.searchByIdWithCliente(22L);
		
		em.close();
		
		System.out.print(pedido.getCliente().getName());
		
		
	}
}
