package com.chadli05.eCommerce.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.chadli05.eCommerce.entities.User;

public interface UserDao extends JpaRepository<User, Long>{
	public Page<User> findByUsernameContaining(String username, Pageable pageable);
}
