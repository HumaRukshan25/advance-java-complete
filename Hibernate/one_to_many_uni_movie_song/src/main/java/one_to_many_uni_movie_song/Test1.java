package one_to_many_uni_movie_song;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
//24/02/2025 repeat batch 2pm
public class Test1 {
	public static void main(String[] args) {
		  EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
	        EntityTransaction et = em.getTransaction();
	        
	        int mid=1;
	       Movie m= em.find(Movie.class, mid);
	        System.out.println(m.getTitle());//movie name
	        
	        
	}

}
