package com.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.entity.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

}
