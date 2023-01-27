package com.blog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.converter.Dtoconvertor;
import com.blog.entity.User;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payloads.UserDto;
import com.blog.responses.UserResponse;
import com.blog.services.IUserService;

@RestController
public class UserController {

	@Autowired
	IUserService userserviceimpl;

	@Autowired
	private Dtoconvertor dtoconvertor;

	@PostMapping("/createuser/")
	public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserDto userdto) {
		UserResponse resp = this.userserviceimpl.createUser(dtoconvertor.dtoToUser(userdto));
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}

	@PutMapping("/updateuser/{id}")
	public ResponseEntity<UserResponse> updateUser(@Valid @RequestBody UserDto userdto, @PathVariable Long id)
			throws ResourceNotFoundException {
		UserResponse resp = this.userserviceimpl.updateUser(userdto, id);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@GetMapping("/getuser/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
		User resp = this.userserviceimpl.getUser(id);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@GetMapping("/getusers")
	public ResponseEntity<?> getallUsers() {
		List<User> resp = this.userserviceimpl.getAllUser();
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

}
