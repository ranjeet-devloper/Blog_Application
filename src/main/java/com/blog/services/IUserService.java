package com.blog.services;

import java.util.List;
import java.util.Optional;

import com.blog.entity.User;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payloads.UserDto;
import com.blog.responses.UserResponse;

public interface IUserService {
   
	public UserResponse createUser(User user);
	public UserResponse updateUser(UserDto userdto,Long id) throws ResourceNotFoundException;
	public List<User> getAllUser();
	public User getUser(long id);
	
}
