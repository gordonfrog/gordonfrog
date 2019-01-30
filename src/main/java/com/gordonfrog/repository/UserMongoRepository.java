package com.gordonfrog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.gordonfrog.model.User;

public interface UserMongoRepository extends MongoRepository<User, Integer> {
	public User findByName(String name);
}
