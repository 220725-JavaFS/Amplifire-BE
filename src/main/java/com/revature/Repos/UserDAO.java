package com.revature.Repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.LibraryUser;

public interface UserDAO extends JpaRepository<LibraryUser, Integer> {

	Optional<LibraryUser> findByuserName(String userName);

}
