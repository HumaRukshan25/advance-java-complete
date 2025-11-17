package one_to_one_uni_practice;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class FetchCountryById {
	public static void main(String[] args) {
		EntityManager em=Persistence.createEntityManagerFactory("dev").createEntityManager();
		System.out.println("enter id:");
		Country c=em.find(Country.class,new Scanner(System.in).nextInt());
		
		System.out.println(c.getName());
		System.out.println(c.getCapitalCity());
		System.out.println(c.getPresident().getName());
		//DeleteCountryById assignment 30/10/2024
		
	}

}
