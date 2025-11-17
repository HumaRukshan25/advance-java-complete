package org.jsp.ums;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class App {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	static EntityManager em = emf.createEntityManager();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		while (true) {
			System.out.println("Select Option");
			System.out.println("1) Login");
			System.out.println("2) Create Account");
			System.out.println("3) Delete Account By Id");
			System.out.println("4) View All Accounts");
			System.out.println("5) Exit");
			switch (sc.nextInt()) {
			case 1:
				login();
				break;
			case 2:
				insertUser();
				break;
			case 3:
				deleteById();
				break;
			case 4:
				selectAll();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}

//	static void insertUser() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter Name");
//		String name = sc.next();
//		System.out.println("Enter Username");
//		String username = sc.next();
//		System.out.println("Enter Email");
//		String email = sc.next();
//		System.out.println("Enter Phone");
//		long phone = sc.nextLong();
//		System.out.println("Enter Password");
//		String password = sc.next();
//		User u = new User();
//		EntityTransaction et = em.getTransaction();
//		et.begin();
//		User dbUser = em.merge(u);
//		et.commit();
//		System.out.println(dbUser);
//		System.out.println("User Inserted SUccessfully...");
//	}

	static void login() {
		System.out.println("Enter Username");
		String username = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();
		Query q = em.createQuery("select u from User u where u.username=:un and u.password=:pwd");
		q.setParameter("un", username);
		q.setParameter("pwd", password);
		User user = (User) q.getSingleResult();
		System.out.println(user);
	}
	static void insertUser() {
	    Scanner sc = new Scanner(System.in);
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
	

	static void deleteById() {
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
	
	static void selectAll() {
		Query q = em.createQuery("from User");
		List<User> ul = q.getResultList();
		for (User u : ul)
			System.out.println(u);
	}
	

}
