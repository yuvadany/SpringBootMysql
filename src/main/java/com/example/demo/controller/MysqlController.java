package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class MysqlController {

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String home() {
		return userService.welcome();
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

	@GetMapping("/allUsers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping(path = "/getUser/{id}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<Optional<User>> getUser(@PathVariable int id) {
		Optional<User> user = userService.getUser(id);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(user);

	}

	@PostMapping("/addUser")	
	public List<User> addUser(@RequestBody User user) {
		userService.addUser(user);
		return userService.getAllUsers();
	}
	
	@PostMapping("/updateUser/{id}")
	@ResponseBody
	public Optional<User> updateUser(@RequestBody User user, @ PathVariable int id) {
		return userService.updateUser(user, id);		
	}


	@DeleteMapping("/removeUser/{id}")
	public List<User> deleteUser(@PathVariable int id) {
		userService.removeUser(id);
		return userService.getAllUsers();
	}
}
