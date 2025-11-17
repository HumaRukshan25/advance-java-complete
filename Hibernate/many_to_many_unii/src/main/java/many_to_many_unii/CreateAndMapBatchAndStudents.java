package many_to_many_unii;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateAndMapBatchAndStudents {
	public static void main(String[] args) {
		EntityManager em=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Student s1=new Student(0,"huma","huma@gmail.com");
		Student s2=new Student(0,"nanda","nanda@gmail.com");
		Student s3=new Student(0,"gagan","gagan@gmail.com");
		Student s4=new Student(0,"dileep","dileep@gmail.com");
		Student s5=new Student(0,"allen","allen@gmail.com");
		
		List<Student> students=new ArrayList<Student>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		
//		Batch b=new Batch(0,"Advance java","JHE-JFFADD-M6",students);
		Batch b1=new Batch(0,"ADvance Java","JHE-JFFADD-M6",students);
		Batch b2=new Batch(0,"SQL","JHE-JFFADD-M1",students);
		Batch b3=new Batch(0,"WEB Tech","JHE-JFFADD-M2",students);
		
		Batch b4=new Batch(0,"React","JHE-JFFADD-M3",students);
		Batch b5=new Batch(0,"Core java","JHE-JFFADD-M4",students);
		
		et.begin();
		em.persist(b1);
		em.persist(b2);
		em.persist(b3);
		em.persist(b4);
		em.persist(b5);
		
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.persist(s4);
		em.persist(s5);
		et.commit();
		
		System.out.println("done😊😊😊");
	}

}
