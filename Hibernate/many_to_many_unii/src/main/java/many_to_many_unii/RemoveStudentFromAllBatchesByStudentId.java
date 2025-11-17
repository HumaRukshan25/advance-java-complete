package many_to_many_unii;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class RemoveStudentFromAllBatchesByStudentId {
	public static void main(String[] args) {
		EntityManager em=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter student id:");
		int sid=sc.nextInt();
		
		Student std=em.find(Student.class,sid);
		
		if(std==null) {
			System.out.println("Invalid student id");
			return ;
		}
		List<Batch>bl=em.createQuery("from Batch").getResultList();
		
//		cocurrent modification exception
		for(Batch b:bl) {
			List<Student> sl=b.getStudents();
			if(sl.contains(std)) {
				sl.remove(sid);
			}
			b.setStudents(sl);
			et.begin();
			em.merge(b);
			et.commit();
		}	
		System.out.println("done---");
		
	}

}
