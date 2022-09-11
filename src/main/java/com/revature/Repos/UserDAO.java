package com.revature.Repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.User;

public interface UserDAO extends JpaRepository<User, Integer> {

	Optional<User> findByName(String name);

}
