package many_to_many_unii;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PrintStudentsNameByBatchId {
	public static void main(String[] args) {
		EntityManager em=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		System.out.println("enter batch id:");
		int bId=new Scanner(System.in).nextInt();
		
		Batch b=em.find(Batch.class, bId);
		System.out.println(b.getName());
		
		List<Student> sl =b.getStudents();
		List<Batch> bl=em.createQuery("from Batch").getResultList();
		
		for(Batch bb:bl) {
			List<Student> ssl =bb.getStudents();
	if(ssl.containsAll(sl)) {
		System.out.println(bb.getName());
		
		
	}
		}
	}

}
