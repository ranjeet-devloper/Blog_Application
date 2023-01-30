package com.blog.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDto {

	@NotBlank
	@Size(min = 4, message = "minimum size of category tittle should be 4")
	private String categoryTittle;
	@NotBlank
	@Size(min = 10, message = "minimum size of category description should be 10")
	private String categoryDesription;

}
