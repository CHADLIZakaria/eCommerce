package com.chadli05.eCommerce;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.chadli05.eCommerce.controller.ProductController;
import com.chadli05.eCommerce.dao.CategoryDao;
import com.chadli05.eCommerce.dao.CommentDao;
import com.chadli05.eCommerce.dao.ProductDao;
import com.chadli05.eCommerce.dao.UserDao;
import com.chadli05.eCommerce.entities.Category;
import com.chadli05.eCommerce.entities.Product;
import com.chadli05.eCommerce.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner {

	@Autowired
	ProductDao productDao;
	@Autowired
	UserDao userDao;
	@Autowired
	CommentDao commentDao;
	@Autowired
	CategoryDao categoryDao;

	public static void main(String[] args) {
		new File(ProductController.uploadsDirectory).mkdir();
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (Long i = 1L; i < 6; i++) {
			List<Product> products = new ArrayList<>();
			productDao.save(new Product(0L, "product " + (i), "product " + (i), "",
					new User(0L, "user " + (i), "firstName " + (i + 1), "lastName " + (i),"password", "email " + (i), products),
					new Category("category" + i)));
		}
		// for(int i=0; i<20; i++) {
		// //userDao.save(new User(null,"user "+(i+1),"firstName "+(i+1),"lastName
		// "+(i+1), "email "+(i+1), new Product(null,"product "+(i+1),"product "+(i+1),
		// null));
		// }
		// for(int i=0; i<20; i++) {
		// commentDao.save(new Comment(null,"Comment "+(i+1)));
		// }

	}

}
