package composite_key;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveUser {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
	UserId ui= new UserId("iuihuma@123",98987499);
	//if we pass the same values for email and phone we will get exception  java.sql.SQLIntegrityConstraintViolationException: 
	User u=new User(ui,"huma","gduy78");
		 et.begin();
		 em.persist(u);
		 
		 
		 et.commit();
	}

}
