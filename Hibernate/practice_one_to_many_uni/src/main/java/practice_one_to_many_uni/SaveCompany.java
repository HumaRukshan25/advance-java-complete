package practice_one_to_many_uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveCompany {
	public static void main(String[] args) {
		EntityManager em= Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Company c=new Company(0,"microsoft","sarjapur road","4-SEP-1998",null);
		et.begin();
		em.persist(c);
		et.commit();
		System.out.println("done");
		
	}

}
