package com.blog.services;

import java.util.List;

import com.blog.payloads.CategoryDto;

public interface ICategoryService {

	CategoryDto createCatyegory(CategoryDto categoryDto);

	CategoryDto updateCatyegory(CategoryDto categoryDto, Integer id);

	void deleteCategory(Integer id);

	CategoryDto getCatyegory(Integer categoryId);

	List<CategoryDto> getAllCategory();

}
