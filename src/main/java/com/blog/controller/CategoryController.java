package com.blog.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.blog.entity.Category;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payloads.CategoryDto;
import com.blog.responses.UserResponse;
import com.blog.services.impl.CategoryServiceImpl;

@RestController
public class CategoryController {

	@Autowired
	private CategoryServiceImpl categoryServiceImpl;

	@PostMapping("/createcategory")
	public ResponseEntity<UserResponse> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		UserResponse resp = this.categoryServiceImpl.createCatyegory(categoryDto);
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}

	@PutMapping("/updatecategory/{id}")
	public ResponseEntity<UserResponse> updatecategory(@Valid @RequestBody CategoryDto categoryDto,
			@PathVariable Long id) throws ResourceNotFoundException {
		UserResponse resp = this.categoryServiceImpl.updateCatyegory(categoryDto, id);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@GetMapping("/getcategory/{id}")
	public ResponseEntity<Category> getCategory(@PathVariable("id") Long id) {
		Category resp = this.categoryServiceImpl.getCatyegory(id);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@DeleteMapping("/deletecategory/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable("id") Long id) {

		return ResponseEntity.ok(this.categoryServiceImpl.deleteCategory(id));
	}

	@GetMapping("/getcategory")
	public ResponseEntity<List<Category>> getallUsers() {
		List<Category> resp = this.categoryServiceImpl.getAllCategory();
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

}
