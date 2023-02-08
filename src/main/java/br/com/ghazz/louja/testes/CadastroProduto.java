package br.com.ghazz.louja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ghazz.louja.modelo.Produto;

public class CadastroProduto {

	public static void main(String[] args) {
		Produto celular = new Produto();
		celular.setName("Iphone 14");
		celular.setDesc("The second best camera");
		celular.setPrice(new BigDecimal("11000"));

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("louja");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(celular);
		em.getTransaction().commit();
		em.close();
	}

}
