package practice_one_to_many_uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveEmployee {
	public static void main(String[] args) {
		EntityManager em= Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et=em.getTransaction();
		Employee e=new Employee(0,"smith1","Dev",3000);
		et.begin();
		em.persist(e);
		et.commit();
		System.out.println("done");
		
	}

}
