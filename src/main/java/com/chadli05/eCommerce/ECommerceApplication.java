package com.chadli05.eCommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.chadli05.eCommerce.dao.ProductDao;
import com.chadli05.eCommerce.entities.Product;

@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner{

	@Autowired
	ProductDao productDao;
	
	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for(int i=0; i<20; i++) {
			productDao.save(new Product(null,"product "+(i+1),"product "+(i+1)));
		}
		
	}

}
