package org.jsp.ums;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class LoginApp {
	
	public static void main(String[] args) {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
//		EntityManager em=emf.createEntityManager();
//		Scanner sc=new Scanner(System.in);
//
//		
//		System.out.println("enter username:");
//		String username=sc.next();
//		
//		
//		
//		System.out.println("enter password:");
//		String password=sc.next();
//		
////		Query q=em.createQuery("select u from User u where u.username=?1 and u.password=?2");//placeholder 1 and 2 continuity shld be like 71 then 72
//	Query q=em.createQuery("select u from User u where u.username=:un and u.password=:p");
//	
//		
////		q.setParameter(1, username);
////		q.setParameter(2, password);
//		
//		q.setParameter("un", username);
//		q.setParameter("pwd", password);
//		
//		
//		User user=(User)q.getSingleResult();//not recommended
////		List<User> ul=q.getResultList(); //giving list of users
////		System.out.println(ul);
//		System.out.println(user);

}
}
