package composite_key;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveApplicant {
	public static void main(String[] args) {
		EntityManager em=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		MyId myId=new MyId();
		//either of email or phone should be different from already present data
		myId.setEmail("huma123@gmail.com");
		myId.setPhone(2282348);
		Applicant a=new Applicant(myId,"ABC","123");
		et.begin();
		em.persist(a);
		et.commit();
		System.out.println("Done");
	}

}
