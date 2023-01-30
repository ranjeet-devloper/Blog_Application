package com.blog.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.blog.converter.Dtoconvertor;
import com.blog.entity.Category;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payloads.CategoryDto;
import com.blog.repositories.ICategoryRepository;
import com.blog.responses.UserResponse;
import com.blog.services.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryRepository iCategoryRepository;

	@Autowired
	private Dtoconvertor dtoconvertor;

	@Override
	public UserResponse createCatyegory(CategoryDto categoryDto) {

		iCategoryRepository.save(dtoconvertor.dtoToCategory(categoryDto));

		return UserResponse.builder().responsecode(HttpStatus.CREATED.value())
				.responsemessage("Category Successfully Created").build();
	}

	@Override
	public UserResponse updateCatyegory(CategoryDto categoryDto, Long id) {

		Optional<Category> x = iCategoryRepository.findById(id);

		if (x.isEmpty()) {
			throw new ResourceNotFoundException("Category", "id", id);
		} else {
			Category p = dtoconvertor.dtoToCategory(categoryDto);
			p.setId(x.get().getId());
			this.iCategoryRepository.save(p);
		}

		return UserResponse.builder().responsecode(HttpStatus.OK.value())
				.responsemessage("Category Successfully Updated").build();
	}

	@Override
	public String deleteCategory(Long id) {
		Optional<Category> findById = this.iCategoryRepository.findById(id);
		if (findById.isEmpty()) {
			throw new ResourceNotFoundException("Category", "id", id);
		} else {
			this.iCategoryRepository.deleteById(id);
			return String.format("category with id %d is deleted", id);
		}
	}

	@Override
	public Category getCatyegory(Long categoryId) {
		Optional<Category> findById = this.iCategoryRepository.findById(categoryId);
		if (findById.isEmpty()) {
			throw new ResourceNotFoundException("Category", "id", categoryId);
		} else {
			return findById.get();
		}
	}

	@Override
	public List<Category> getAllCategory() {

		return this.iCategoryRepository.findAll();

	}

}
