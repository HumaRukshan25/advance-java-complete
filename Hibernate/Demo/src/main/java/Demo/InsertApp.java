package Demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertApp {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		User u=new User();
		u.setId(112);
		u.setName("Huma");
		u.setEmail("huma@gmail.com");
		u.setPhone(740624838);
//		em.persist(u); //here also u can do persist
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(u);
		et.commit();
		System.out.println("user saved sucessfully");
		
	}

}
