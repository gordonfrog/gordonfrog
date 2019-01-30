package com.gordonfrog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gordonfrog.model.User;
import com.gordonfrog.service.UserService;

@RestController
//@RequestMapping("user-api/v1")
// Save, Update, Delete, getallUsers, getUser, findUserByName
public class UserController {
	private final UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping(value = "users/all")
	public List<User> getAllUsers() {
		return service.getAllUsers();

	}

	@GetMapping(value = "users/{id}")
	public User getUser(@PathVariable Integer id) {
		return service.getUser(id);
	}

	@PostMapping(value = "users")
	public User save(@RequestBody User user) {
		return service.save(user);
	}

	@PutMapping(value = "users/{id}")
	public User update(@PathVariable Integer id, @RequestBody User user) {
		return service.update(id, user);
	}

	@DeleteMapping(value = "users/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "User "+ id + " has been deleted.";
	}

	@GetMapping(value = "users")
	public User findUserByName(@RequestParam("name") String name) {
		return service.findUserByName(name);
	}
}
