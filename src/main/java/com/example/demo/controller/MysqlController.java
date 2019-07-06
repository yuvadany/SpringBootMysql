package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class MysqlController {

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String home() {
		return "Logged in Successfully";
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

	@GetMapping("/allUsers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/getUser/{id}")
	public Optional<User> getUser(@PathVariable int id) {
		return userService.getUser(id);
	}
	
	@PostMapping("/addUser")
	public List<User> addUser(@RequestBody User user) {
		 userService.addUser(user);
		 return userService.getAllUsers();
	}
	
	@DeleteMapping("/removeUser/{id}")
	public List<User> removeUser(@PathVariable int id) {
		 userService.removeUser(id);
		 return userService.getAllUsers();
	}
}

