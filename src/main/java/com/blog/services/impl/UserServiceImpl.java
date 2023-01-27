package com.blog.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.converter.Dtoconvertor;
import com.blog.entity.User;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payloads.UserDto;
import com.blog.repositories.IUserRepo;
import com.blog.responses.UserResponse;
import com.blog.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepo userrepo;

	@Autowired
	private Dtoconvertor dtoconvertor;

	@Override
	public UserResponse createUser(User user) {
		userrepo.save(user);
		return new UserResponse("201", "user sucessfully created");
	}

	@Override
	public UserResponse updateUser(UserDto userdto, Long id) throws ResourceNotFoundException {

		Optional<User> x = userrepo.findById(id);
		if (x.isEmpty()) {
			throw new ResourceNotFoundException("user", "id", id);
		} else {
			User user = dtoconvertor.dtoToUser(userdto);
			user.setId(id);
			userrepo.save(user);
		}

		return new UserResponse("200", "user Successfully updated");
	}

	@Override
	public User getUser(long id) {
		if (!userrepo.findById(id).isEmpty()) {
			return userrepo.findById(id).get();
		} else {
			throw new ResourceNotFoundException("user", "id", id);
		}
	}

	@Override
	public List<User> getAllUser() {
		return userrepo.findAll();

	}

}
