package com.blog.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blog.entity.User;
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

}
