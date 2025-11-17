package one_to_one_uni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;



public class FetchPersonById {
	public static void main(String[] args) {
		EntityManager em=Persistence.createEntityManagerFactory("dev").createEntityManager();
		System.out.println("enter id:");
		Person p=em.find(Person.class,new Scanner(System.in).nextInt());
		System.out.println(p.getName());//san
		System.out.println(p.getEmail());//san@gmail.com
		System.out.println(p.getPc());//one_to_one_uni.PanCard@79518e00
		
	
	}

}



