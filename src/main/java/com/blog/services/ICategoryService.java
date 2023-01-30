package com.blog.services;

import java.util.List;

import com.blog.entity.Category;
import com.blog.payloads.CategoryDto;
import com.blog.responses.UserResponse;

public interface ICategoryService {

	UserResponse createCatyegory(CategoryDto categoryDto);

	UserResponse updateCatyegory(CategoryDto categoryDto, Long id);

	String deleteCategory(Long id);

	Category getCatyegory(Long categoryId);

	List<Category> getAllCategory();

}
