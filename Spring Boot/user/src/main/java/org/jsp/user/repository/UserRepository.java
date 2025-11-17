

package org.jsp.user.repository;

//import java.util.List;


import org.jsp.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User,Integer>{

}


