package Demoo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test1 {
	public static void main(String[] args) {
		EntityManager em=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et=em.getTransaction();
		Orders o=new Orders();
		o.setAmount(200);
		
	
		
//		Orders o=em.find(Orders.class, 1);
		
//		o.setAmount(351);
//		o.setAmount(800);
		
		et.begin();
		em.persist(o);
//		em.merge(o);
		et.commit();
		System.out.println("done");
	}

}
