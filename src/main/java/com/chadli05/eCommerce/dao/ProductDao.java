package com.chadli05.eCommerce.dao;

import java.util.List;

import com.chadli05.eCommerce.entities.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductDao extends JpaRepository<Product, Long> {
	public Page<Product> findByNameContaining(String name, Pageable pageable);

	public List<Product> findByNameContaining(String name);

	@Query("select p from Product p where p.id=?1")
	public List<Product> findAllByCategoryId(Long id);
}
