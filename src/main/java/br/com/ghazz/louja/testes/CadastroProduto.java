package br.com.ghazz.louja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ghazz.louja.dao.CategoriaDao;
import br.com.ghazz.louja.dao.ProdutoDao;
import br.com.ghazz.louja.modelo.Categoria;
import br.com.ghazz.louja.modelo.Produto;
import br.com.ghazz.louja.util.JPAUtil;

public class CadastroProduto {

	public static void main(String[] args) {
		cadastrarProduto();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		List<Produto> p = produtoDao.searchByCategoriaNome("Usados");
		
		p.forEach(p2 -> System.out.println(p2.getName()));
		
		BigDecimal preco = produtoDao.searchProductPriceByName("S22");
		System.out.println("Preço do celular: " + preco);
	}
	
	public static void cadastrarProduto() {
		Categoria categoria = new Categoria("Usados");				
		
		Produto celular = new Produto("Iphone 14","The second best camera"
				,new BigDecimal("11000"), categoria);
		
		Categoria categoria2 = new Categoria("Usados2");				
		
		Produto celular2 = new Produto("S22","The best camera"
				,new BigDecimal("9000"), categoria2);

		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(categoria);
		em.persist(celular);
		em.persist(categoria2);
		em.persist(celular2);
		celular.setName("Google phone");
		
		em.getTransaction().commit();
	    em.close();
		
		
		/*
		EntityManager em = JPAUtil.getEntityManager();

		CategoriaDao categoriaDao = new CategoriaDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		em.getTransaction().begin();
		
		categoriaDao.save(categoria);
		produtoDao.save(celular);
				
		em.getTransaction().commit();
		em.close();
		*/
	}

}
