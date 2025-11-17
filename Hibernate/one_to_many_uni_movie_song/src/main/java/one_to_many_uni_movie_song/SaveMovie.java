package one_to_many_uni_movie_song;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveMovie {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
        EntityTransaction et = em.getTransaction();

        Movie movie = new Movie();
        movie.setTitle("Inception");
        movie.setGenre("Sci-Fi");

        et.begin();
        Movie savedMovie = em.merge(movie);
        et.commit();

        System.out.println(savedMovie);
        System.out.println("Movie saved successfully...");
        em.close();
    }
}
