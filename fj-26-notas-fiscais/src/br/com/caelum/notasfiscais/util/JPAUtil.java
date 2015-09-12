package br.com.caelum.notasfiscais.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;



@ApplicationScoped
public class JPAUtil {
	
//	@PersistenceUnit(name="notas")
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("notas");

	@Produces @RequestScoped
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	@RequestScoped
	public void close(@Disposes EntityManager em) {
		System.out.println("Fechando o entityManager");
		em.close();
	}
	
	
}