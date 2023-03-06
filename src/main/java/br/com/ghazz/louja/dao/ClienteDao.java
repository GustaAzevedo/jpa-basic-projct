package br.com.ghazz.louja.dao;

import javax.persistence.EntityManager;
import br.com.ghazz.louja.modelo.Cliente;

public class ClienteDao {

	private EntityManager em;

	public ClienteDao(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void save(Cliente cliente) {
		this.em.persist(cliente);
	}
	
	public void update(Cliente cliente) {
		this.em.merge(cliente);
	}
	
	public void delete(Cliente cliente) {
		cliente = em.merge(cliente);
		this.em.remove(cliente);;
	}
	
}
