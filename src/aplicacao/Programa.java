package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		/*Um objeto EntityManagerFactory � utilizado para instanciar objetos EntityManager. Escopo: tipicamente mantem-se 
		 * uma inst�ncia �nica de EntityManagerFactory para toda aplica��o.   */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		
		/*Um objeto EntityManager encapsula uma conex�o com a base de dados e serve para efetuar opera��es de acesso a dados 
		 * (inser��o, remo��o, dele��o, atualiza��o) em entidades (clientes, produtos, pedidos, etc.) */
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
