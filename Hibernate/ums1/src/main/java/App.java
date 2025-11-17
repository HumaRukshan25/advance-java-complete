

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

//19/02/2025 repeat batch 2pm

public class App {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	static EntityManager em = emf.createEntityManager();
	static Scanner sc = new Scanner(System.in);
public static void main(String[] args) {
	boolean flag=true;

	while(flag) {
		System.out.println("Select Option");
	
		System.out.println("1) Create Account");
		System.out.println("2) Delete Account By Id");
		System.out.println("3) update user");
		System.out.println("4) View a user");
		System.out.println("5)View All Accounts ");
		System.out.println("6) Exit");
		
		int key=sc.nextInt();
		switch(key) {
		case 1:createUser();
		break;
		case 2:deleteUser();
		break;
		case 3:updateUser();
		break;
		case 4:viewUser();
		break;
		case 5:viewAllUser();
			
		case 6:
			System.exit(0);
			break;
		default:
			System.out.println("Invalid Choice");
			break;
		}
	}
}

private static void deleteUser() {
	// TODO Auto-generated method stub
	System.out.println("Enter ID");

	int id = sc.nextInt();
	User user = em.find(User.class, id);
	if (user != null) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(user);
		et.commit();
		System.out.println("User Deleted Successfully..");
	} else {
		System.err.println("Invalid User Id");
	}
	
}


private static void updateUser() {
    System.out.println("Enter ID of the user to update:");
    int id = sc.nextInt();
    User user = em.find(User.class, id);

    if (user != null) {
        System.out.println("Enter new Name:");
        String name = sc.next();
        System.out.println("Enter new Username:");
        String username = sc.next();
        System.out.println("Enter new Email:");
        String email = sc.next();
        System.out.println("Enter new Phone:");
        long phone = sc.nextLong();
        System.out.println("Enter new Password:");
        String password = sc.next();

        EntityTransaction et = em.getTransaction();
        et.begin();
        user.setName(name);
        user.setUsername(username);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);
        et.commit();

        System.out.println("User Updated Successfully...");
    } else {
        System.err.println("Invalid User ID");
    }
}

private static void viewUser() {
    System.out.println("Enter ID of the user to view:");
    int id = sc.nextInt();
    User user = em.find(User.class, id);

    if (user != null) {
        System.out.println("User Details:");
        System.out.println("-------------------------------------");
        System.out.println("ID: " + user.getId());
        System.out.println("Name: " + user.getName());
        System.out.println("Username: " + user.getUsername());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Phone: " + user.getPhone());
        System.out.println("-------------------------------------");
    } else {
        System.err.println("User not found with ID: " + id);
    }
}


private static void createUser() {
	// TODO Auto-generated method stub
	 System.out.println("Enter Name");
	    String name = sc.next();
	    System.out.println("Enter Username");
	    String username = sc.next();
	    System.out.println("Enter Email");
	    String email = sc.next();
	    System.out.println("Enter Phone");
	    long phone = sc.nextLong();
	    System.out.println("Enter Password");
	    String password = sc.next();
	    
	    // Populate the User object with all necessary values
	    User u = new User();
	    u.setName(name);
	    u.setUsername(username);
	    u.setEmail(email);
	    u.setPhone(phone);
	    u.setPassword(password);

	    EntityTransaction et = em.getTransaction();
	    et.begin();
	    em.persist(u);  // Use persist instead of merge for new entities
	    et.commit();
	    System.out.println(u);
	    System.out.println("User Inserted Successfully...");
	
}
private static void viewAllUser() {
    Query q = em.createQuery("from User");
    List<User> ul = q.getResultList();

    if (ul.isEmpty()) {
        System.out.println("No users found.");
    } else {
        System.out.println("List of Users:");
        System.out.println("-------------------------------------");
        for (User u : ul) {
            System.out.println("ID: " + u.getId());
            System.out.println("Name: " + u.getName());
            System.out.println("Username: " + u.getUsername());
            System.out.println("Email: " + u.getEmail());
            System.out.println("Phone: " + u.getPhone());
            System.out.println("-------------------------------------");
        }
    }
}

}
