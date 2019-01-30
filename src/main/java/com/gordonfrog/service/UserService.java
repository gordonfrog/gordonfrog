package com.gordonfrog.service;

import java.util.List;

import com.gordonfrog.model.User;

public interface UserService {

	List<User> getAllUsers();

	User getUser(Integer id);

	User save(User user);

	User update(Integer id, User user);

	void delete(Integer id);

	User findUserByName(String name);

}
