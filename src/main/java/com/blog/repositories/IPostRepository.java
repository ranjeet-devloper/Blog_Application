package com.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entity.Category;
import com.blog.entity.Post;
import com.blog.entity.User;

public interface IPostRepository extends JpaRepository<Post, Long> {
	List<Post> findByUser(User user);

	List<Post> findByCategory(Category category);
}
