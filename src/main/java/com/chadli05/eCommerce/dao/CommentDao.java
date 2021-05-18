package com.chadli05.eCommerce.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.chadli05.eCommerce.entities.Comment;

public interface CommentDao extends JpaRepository<Comment, Long>{
	public Page<Comment> findByCommentContaining(String comment, Pageable pageable);
}
