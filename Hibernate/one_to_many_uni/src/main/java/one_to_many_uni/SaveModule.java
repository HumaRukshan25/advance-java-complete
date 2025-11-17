
package one_to_many_uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveModule {
	public static void main(String[] args) {
		EntityManager em=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et=em.getTransaction();
		Module m=new Module();
		m.setName("j2ee");
		et.begin();
		Module dbm=em.merge(m);
		et.commit();
		System.out.println(dbm);
		System.out.println("done.....");
	}

}
