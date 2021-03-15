package com.chadli05.eCommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chadli05.eCommerce.entities.Category;

public interface CategoryDao extends JpaRepository<Category, Long> {

}
