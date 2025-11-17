package many_to_many_bi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveAndMapStudentsAndBatches {
	public static void main(String[] args) {
		EntityManager em=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		
		Batch b1=new Batch(0,"core java","123J456JAVA",null);
		Batch b2=new Batch(0,"advance java","123J456ADVANCEJAVA",null);
		Batch b3=new Batch(0,"SQL","123J456SQL",null);
		
		Student s1=new Student(0,"gagan","gagan@gmail.com",null);
		Student s2=new Student(0,"huma","huma@gmail.com",null);
		Student s3=new Student(0,"sania","sania@gmail.com",null);
		
		List<Batch>batchs=new ArrayList<Batch>();
		batchs.add(b1);
		batchs.add(b2);
		batchs.add(b3);
		
		List<Student> students=new ArrayList<Student>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
		b1.setStudents(students);
		b2.setStudents(students);
		b3.setStudents(students);
		
		s1.setBatchs(batchs);
		s2.setBatchs(batchs);
		s3.setBatchs(batchs);
		
		et.begin();
	
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.persist(b1);
		em.persist(b2);
		em.persist(b3);
		
		et.commit();
		
		System.out.println("Done..");
	
		
	}

}
