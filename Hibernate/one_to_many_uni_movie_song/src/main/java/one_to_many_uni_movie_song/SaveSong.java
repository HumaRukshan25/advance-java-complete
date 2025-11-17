package one_to_many_uni_movie_song;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveSong {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
        EntityTransaction et = em.getTransaction();

        Song song = new Song();
        song.setTitle("T");
        song.setArtist("H");
        
        

        et.begin();
        Song savedSong = em.merge(song);
        et.commit();

        System.out.println(savedSong);
        System.out.println("Song saved successfully...");
        em.close();
    }
}
