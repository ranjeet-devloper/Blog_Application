package com.blog.services;

import java.util.List;

import com.blog.entity.Post;
import com.blog.payloads.PostDto;

public interface IPostService {

	Post createPost(PostDto postDto);

	Post updatePost(PostDto postDto, Long id);

	String deletePost(Long id);

	List<Post> getAllPost();

	Post getPostById(Long id);

	List<Post> getPostByCategory(Long categoryId);

	List<Post> getPostByUser(Long userId);

	List<Post> searchPosts(String keyword);

}
