package org.jsp.ums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	ProductRepository repo;
	
	@RequestMapping("/product")

	public Product student(@RequestBody Product p) {
		repo.save(p);
		return p;
	}

}
