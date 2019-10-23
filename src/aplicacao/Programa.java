package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

		// Instanciando os obj das classes
		Pessoa p1 = new Pessoa(null, "Carlos da silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Rodrigo da silva", "rodrigo@gmail.com");
		Pessoa p3 = new Pessoa(null, "Felipe da silva", "felipe@gmail.com");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		System.out.println("Pronto");

	}

}
