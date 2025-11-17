package many_to_many_unii;
//student id delete batch assignment
//remove students by student id
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteBatchByStudentId {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
        EntityTransaction et = em.getTransaction();
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("Enter student ID:");
        int sid = sc.nextInt();
        
        Student std=em.find(Student.class, sid);
        
        List<Batch> bl = em.createQuery("from Batch").getResultList();
        
        for(Batch b:bl) 
        	
        {
        	
        	List<Student> sl=b.getStudents();
        	if(sl.contains(std)) {
        		et.begin();
        		em.remove(b);
        		et.commit();
        	}
        	
        }
        System.out.println("done===done");

//        System.out.println("Enter student ID:");
//        int studentId = sc.nextInt();  
//        // Find the student by ID
//        Student student = em.find(Student.class, studentId);
//        if (student == null) {
//            System.out.println("Invalid student ID.");
//            sc.close();
//            em.close();
//            return; // Exit if student ID is invalid
//        }
//
//        // Find batches associated with the student ID using a query
//        Query query = em.createQuery("SELECT b FROM Batch b JOIN b.students s WHERE s.id = :studentId");
//        query.setParameter("studentId", studentId);
//        List<Batch> batches = query.getResultList();
//
//        if (batches.isEmpty()) {
//            System.out.println("No batches found for this student.");
//            sc.close();
//            em.close();
//            return;
//        }
//
//        // Delete each batch associated with the student
//        et.begin();
//        for (Batch batch : batches) {
//            batch.getStudents().remove(student); // Remove student from batch
//            em.remove(em.contains(batch) ? batch : em.merge(batch)); // Remove the batch from the database
//        }
//        em.remove(student); // Optionally, remove the student itself if no longer needed
//        et.commit();
//
//        System.out.println("All batches associated with student ID " + studentId + " deleted successfully.");
//        sc.close();
//        em.close();
    }
}
