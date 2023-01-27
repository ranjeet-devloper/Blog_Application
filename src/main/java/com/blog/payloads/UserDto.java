package com.blog.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

	private Integer id;
	@NotBlank(message = "name should contain atlest 16 character")
	private String name;
	@Email
	private String email;
	@NotBlank(message = "password must be contain atleast one characher,one number")
	private String password;
	@NotBlank
	@Size(min = 10, message = "about must be not blank")
	private String about;

}
