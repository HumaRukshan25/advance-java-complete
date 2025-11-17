package one_to_one_bi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


//one to many bidirectional assignment

public class CreateAndMapPersonAndPancard {
	public static void main(String[] args) {
		
		EntityManager em=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et=em.getTransaction();
		Scanner sc=new Scanner(System.in);
		Person p=new Person();
		System.out.println("enter name:");
		p.setName(sc.next());
		System.out.println("enter phone:");
		p.setPhone(sc.nextLong());
		
		PanCard pc=new PanCard();
		System.out.println("enter pancard number");
		pc.setpNo(sc.next());
		System.out.println("enter pin code");
		pc.setPin(sc.nextInt());
		
		/*important*/
		p.setPc(pc);
		pc.setPerson(p);
		
		
		et.begin();
		em.persist(p);
		em.persist(pc);
		et.commit();
		
		System.out.println("done.......");
		
	}

}
