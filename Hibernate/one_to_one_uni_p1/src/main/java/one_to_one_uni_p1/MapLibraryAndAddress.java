package one_to_one_uni_p1;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MapLibraryAndAddress {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
        EntityTransaction et = em.getTransaction();

        Library library = em.find(Library.class, 1);
        Address address = em.find(Address.class, 1);

        library.setAddress(address);

        et.begin();
        em.merge(library);
        et.commit();

        System.out.println("Library and Address mapped successfully.");
    }
}
