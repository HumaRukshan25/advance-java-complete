package hlc;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
//to understand hibernate life cycle(hlc) gagan sir did this 
public class Test1 {
	public static void main(String[] args) {
		EntityManager em=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		User u=new User();//Transient phase/state: when object is created
		u.setName("huma");
		u.setEmail("huma@gmail.com");
		u.setPhone(934683696);
		u.setPassword("123");
		
		System.out.println(u);//hlc.User@10db6131
		System.out.println(em.contains(u));//false
		
		et.begin();
		System.out.println(em.contains(u));//false
		System.out.println(u);//hlc.User@10db6131
		em.persist(u);//Transient to Persistent phase/state
		System.out.println(em.contains(u));//true
		
		u.setName("ijk");
		u.setPhone(836);
		
		et.commit();
		
		em.detach(u);//Detached phase/state
		System.out.println(em.contains(u));//false
		
		
		
	}

}
