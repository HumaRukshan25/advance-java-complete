package one_to_many_uni_movie_song;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class PrintMovieNameBySongId {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		EntityManager em=Persistence.createEntityManagerFactory("dev").createEntityManager();
		int sid=3;
		Song s=em.find(Song.class,sid);
		List<Movie> m1=em.createQuery("from Movie").getResultList();
		for(Movie m:m1) {
			List<Song> s1=m.getSongs();
			for(Song song:s1) {
				if(song.getId()==s.getId()) {
					System.out.println(m.getTitle());
				}
				
			}
		}
	}

}
