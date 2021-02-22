package com.chadli05.eCommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chadli05.eCommerce.entities.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

}
