package one_to_one_uni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MapPersonAndPanCard {
	public static void main(String[] args) {

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		
		int pid=1;
		int pcid=2;
		Person p=em.find(Person.class, pid);
		PanCard pc=em.find(PanCard.class, pcid);
		
//		p.setName("hu");
		p.setPc(pc);
		
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(p);
		et.commit();
		System.out.println("done mapping");
	}

}
