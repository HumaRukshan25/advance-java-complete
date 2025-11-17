package org.jsp;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
    static EntityManager em = emf.createEntityManager();

    @RequestMapping("/add")
    public ModelAndView addProduct(
            @RequestParam String pname,
            @RequestParam String pdesc,
            @RequestParam int price) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Product product = new Product(0, pname, pdesc, price);
        em.persist(product);  // Persist instead of merge for new entity
        et.commit();

        ModelAndView mv = new ModelAndView();
        mv.setViewName("success.jsp");
        mv.addObject("id", product.getId());
        mv.addObject("name", product.getPname());
        return mv;
    }

    @RequestMapping("/prodpage")
    public ModelAndView prodPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("add.jsp");
        return mv;
    }

    @RequestMapping("/all")
    public ModelAndView findAllProducts() {
        List<Product> productList = em.createQuery("from Product", Product.class).getResultList();

        ModelAndView mv = new ModelAndView();
        mv.setViewName("allproducts.jsp");
        mv.addObject("products", productList);
        return mv;
    }

    @RequestMapping("/delete")
    public ModelAndView deleteProductById(@RequestParam int id) {
        Product p = em.find(Product.class, id);
        if (p != null) {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(p);
            et.commit();
            return findAllProducts();
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("index.jsp");
        mv.addObject("msg", "Invalid Product ID. Unable to delete.");
        return mv;
    }
}
