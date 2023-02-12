package br.com.ghazz.louja.testes;

import java.math.BigDecimal;

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
		Categoria categoria = new Categoria("Usados");				
		
		Produto celular = new Produto("Iphone 14","The second best camera"
				,new BigDecimal("11000"), categoria);

		EntityManager em = JPAUtil.getEntityManager();
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		em.getTransaction().begin();
		categoriaDao.SaveCategoria(categoria);
		produtoDao.SaveProduct(celular);
		em.getTransaction().commit();
		em.close();
	}

}
