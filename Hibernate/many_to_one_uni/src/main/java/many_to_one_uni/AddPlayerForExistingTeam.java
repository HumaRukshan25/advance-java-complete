package many_to_one_uni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AddPlayerForExistingTeam {
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
		
		System.out.println("enter player name");
		String name=sc.next();
		
	   System.out.println("enter Jersry number");
	   int jerseyNo=sc.nextInt();
	
	   Player p=new Player(0,name,jerseyNo,t);
	   
	   et.begin();
	   em.persist(p);
	   et.commit();
	   System.out.println("Done🙂");
	   
	}

}
