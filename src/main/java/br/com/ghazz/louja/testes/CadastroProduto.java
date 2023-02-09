package br.com.ghazz.louja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ghazz.louja.dao.ProdutoDao;
import br.com.ghazz.louja.modelo.Categoria;
import br.com.ghazz.louja.modelo.Produto;
import br.com.ghazz.louja.util.JPAUtil;

public class CadastroProduto {

	public static void main(String[] args) {
		Produto celular = new Produto("Iphone 14","The second best camera"
				,new BigDecimal("11000"),Categoria.CELULARES);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		em.getTransaction().begin();
		produtoDao.SaveProduct(celular);
		em.getTransaction().commit();
		em.close();
	}

}
