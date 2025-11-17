package many_to_one_uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateAndMapPlayerAndTeam {
	public static void main(String[] args) {
		EntityManager em=Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		EntityTransaction et=em.getTransaction();
		
		Team t=new Team(0,"US","C");
		
		Player p1=new Player(0,"cgreen",98,t);
		
		
		et.begin();
		em.persist(t);
		em.persist(p1);
		et.commit();

	}
}
