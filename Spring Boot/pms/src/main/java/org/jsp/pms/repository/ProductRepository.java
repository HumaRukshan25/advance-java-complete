package org.jsp.pms.repository;



//import java.util.List;

import org.jsp.pms.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Integer>{

//	@Query("select p from Product where p.name=?1")
//	List<Product> abc(String name);

}
