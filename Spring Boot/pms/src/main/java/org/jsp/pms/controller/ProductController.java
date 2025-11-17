package org.jsp.pms.controller;

import java.util.List;
import java.util.Optional;

import org.jsp.pms.entity.Product;
import org.jsp.pms.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository repo;

    // Save a new product
    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return repo.save(product);
    }

    // Update an existing product
    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return repo.save(product);
    }

    // Find all products
    @GetMapping
    public List<Product> findAll() {
        return repo.findAll();
    }

    // Find product by ID using RequestParam
    @GetMapping("/find")
    public Product findById(@RequestParam int id) {
        Optional<Product> optional = repo.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    // Find product by ID using PathVariable
    @GetMapping("/{id}")
    public Product findByIds(@PathVariable int id) {
        Optional<Product> optional = repo.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    // Delete a product by ID
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id) {
        Optional<Product> optional = repo.findById(id);
        if (optional.isPresent()) {
            repo.deleteById(id);
            return "Product deleted successfully";
        } else {
            return "Invalid ID";
        }
    }
    
//    @GetMapping("/{name}")
//    public List<Product> findByName(@PathVariable String name){
//    	return repo.abc(name);
//    }
}
