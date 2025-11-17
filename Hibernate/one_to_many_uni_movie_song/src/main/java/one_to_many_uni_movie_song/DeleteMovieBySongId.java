package one_to_many_uni_movie_song;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteMovieBySongId {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        int songId = 5; 

        et.begin();
        
        Song song = em.find(Song.class, songId);

        if (song != null) {
         
            List<Movie> movies = em.createQuery("from Movie", Movie.class).getResultList();
            for (Movie movie : movies) {
                
                if (movie.getSongs().remove(song)) {
                    
                    em.merge(movie);
                    System.out.println("Removed song from movie: " + movie.getTitle());
                }
            }
            
            em.remove(song);
            System.out.println("Deleted song with ID: " + songId);
        } else {
            System.out.println("No song found with ID: " + songId);
        }
        
        et.commit();
        em.close();
    }
}
