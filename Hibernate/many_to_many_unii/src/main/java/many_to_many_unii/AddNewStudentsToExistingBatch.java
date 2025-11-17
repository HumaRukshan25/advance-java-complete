package many_to_many_unii;
//student id delete batch assignment
//remove students by student id
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AddNewStudentsToExistingBatch {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
        EntityTransaction et = em.getTransaction();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter batch id:");
        Batch b = em.find(Batch.class, sc.nextInt());
        if (b == null) {
            System.out.println("Invalid batch id");
            return; // Exit if batch id is invalid
        }

        List<Student> students = new ArrayList<Student>();
        
        boolean flag = true;
        while (flag) {
            System.out.println("Do you want to add a student to the batch? (y/n)");
            char ch = sc.next().charAt(0);
            if (ch == 'y' || ch == 'Y') {
                Student s = new Student();
                System.out.println("Enter the name:");
                s.setName(sc.next());
                System.out.println("Enter the email:");
                s.setEmail(sc.next());

                students.add(s);
            } else {
                flag = false;
            }
        }

        List<Student> osl = b.getStudents();
        osl.addAll(students);
        
        et.begin();
        for (Student s : students) {
            em.persist(s); // Persist each new student
        }
        em.merge(b); // Merge the updated batch with added students
        et.commit(); // Commit the transaction once after all updates

        System.out.println("Students added successfully to batch.");
        sc.close();
        em.close();
    }
}
