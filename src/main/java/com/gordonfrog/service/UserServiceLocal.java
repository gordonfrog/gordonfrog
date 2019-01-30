package com.gordonfrog.service;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.gordonfrog.model.User;

//Services should wire in Repository objects to a persistent store
//using the UserDataStub as a stand-in for a db representation - Guru
@Service
@Profile("default")
public class UserServiceLocal implements UserService {

	@Override
	public List<User> getAllUsers() {
		return UserInMemDB.getAllUsers();
	}

	@Override
	public User getUser(Integer id) {
		return UserInMemDB.getUser(id);
	}

	@Override
	public User save(User user) {
		return UserInMemDB.save(user);
	}

	@Override
	public User update(Integer id, User user) {
		return UserInMemDB.update(id, user);
	}

	@Override
	public void delete(Integer id) {
		UserInMemDB.delete(id);
	}

	@Override
	public User findUserByName(String name) {
		return UserInMemDB.findUserByName(name);
	}

}
