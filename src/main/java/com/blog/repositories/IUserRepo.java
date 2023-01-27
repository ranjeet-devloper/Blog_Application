package com.blog.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.entity.User;

@Repository
public interface IUserRepo extends JpaRepository<User, Long> {

	public Optional<User> findById(long id);

}
