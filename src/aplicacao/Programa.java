package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		/*Um objeto EntityManagerFactory é utilizado para instanciar objetos EntityManager. Escopo: tipicamente mantem-se 
		 * uma instância única de EntityManagerFactory para toda aplicação.   */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		
		/*Um objeto EntityManager encapsula uma conexão com a base de dados e serve para efetuar operações de acesso a dados 
		 * (inserção, remoção, deleção, atualização) em entidades (clientes, produtos, pedidos, etc.) */
		EntityManager em = emf.createEntityManager();
		
		/*
		 em.find faz a buscar no BD da classe Pessoa pelo ID 2 // 
		 Pessoa p = em.find(Pessoa.class, 2); // System.out.println(p);
		 */
		
		//em.find faz a buscar no BD da classe Pessoa pelo ID utlizando em.remove(p) para DELETAR
		Pessoa p = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println("Pronto");
		em.close();
		emf.close();
	}

}
