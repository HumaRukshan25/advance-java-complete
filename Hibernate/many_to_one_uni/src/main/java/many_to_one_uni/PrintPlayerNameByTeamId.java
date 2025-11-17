package many_to_one_uni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class PrintPlayerNameByTeamId {
	public static void main(String[] args) {
        EntityManager em=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et=em.getTransaction();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter team id:");
		int tId=sc.nextInt();
		
		Team t=em.find(Team.class, tId);
		
		if(t==null) {
			System.out.println("invalid team id");
			return;
		}
		
	
		List<Player> p1=em.createQuery("from Player").getResultList();
		
		for(Player p:p1) {
			
				if(p.getTeam().getId()==t.getId()) {
					System.out.println(p.getName());
	
				}
		}
	  
	   System.out.println("Done🙂");
	   
	}


}
