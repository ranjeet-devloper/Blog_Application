package com.blog.converter;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blog.entity.Category;
import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.payloads.CategoryDto;
import com.blog.payloads.PostDto;
import com.blog.payloads.UserDto;

@Component
public class Dtoconvertor {

	@Autowired
	ModelMapper modelMapper;

	public User dtoToUser(UserDto userDto) {
		return modelMapper.map(userDto, User.class);
	}

	public UserDto userToDto(User user) {
		return modelMapper.map(user, UserDto.class);
	}

	public Category dtoToCategory(CategoryDto categoryDto) {
		return modelMapper.map(categoryDto, Category.class);
	}

	public CategoryDto categoryToDto(Category category) {
		return modelMapper.map(category, CategoryDto.class);
	}

	public Post dtoToPost(PostDto postDto) {
		Post map = modelMapper.map(postDto, Post.class);
		map.setCategory(null);
		map.setDate(new Date());
		map.setImageName(null);
		map.setUser(null);
		return map;
	}

}
