package org.jsp.ums;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.name = ?1")
    List<User> findByName(String name);

    @Query("select u from User u where u.email = ?1")
    List<User> findByEmail(String email);

    @Query("select u from User u where u.email = ?1 and u.password = ?2")
    List<User> findByEmailAndPassword(String email, String password);
}
