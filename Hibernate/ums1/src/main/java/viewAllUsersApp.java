import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


//19/02/2025 repeat batch 2pm
public class viewAllUsersApp {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		
		Query q=em.createQuery("select u from User u");
		List<User> ul=q.getResultList();
		ListIterator<User> itr=ul.listIterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
