package many_to_many_unii;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateBatchAndMapOldStudents {
	public static void main(String[] args) {
		EntityManager em=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et=em.getTransaction();
		
//		Student s16 =em.find(Student.class, 16);
//		Student s17 =em.find(Student.class, 17);
//		
		List<Student> students=new ArrayList<Student>();
//		students.add(s16);
//		students.add(s17);
		Student s21=new Student(0,"abc","abc@gmail.com");
		Student s22=new Student(0,"ijk","ijk@gmail.com");
		students.add(s21);
	students.add(s22);
		
		
		Batch b=new Batch(0,"social science","BC123DEF",students);
		et.begin();
		em.persist(b);
		em.persist(s21);
		em.persist(s22);
		et.commit();
		System.out.println("done");
		
		
	}

}
