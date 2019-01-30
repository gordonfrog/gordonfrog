package com.gordonfrog.repository;

import org.springframework.data.repository.CrudRepository;

import com.gordonfrog.model.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserCRUDRepository extends CrudRepository<User, Integer> {
	/**
	   * This method will find an User instance in the database by its name.
	   * Note that this method is not implemented and its working code will be
	   * automagically generated from its signature by Spring Data JPA.
	   */
	public User findByName(String name);
}
