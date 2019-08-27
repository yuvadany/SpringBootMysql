package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	public UserRepo userRepo;

	@Autowired
	User imputUser;

	public String welcome() {
		logger.info("inside welcome() - user service");
		return "welcome";
	}

	public List<User> getAllUsers() {
		logger.info("inside getAllUsers() - user service");
		return userRepo.findAll();
	}

	public List<User> findByRole(String role) {
		logger.info("inside findByRole() - user service");
		return userRepo.findByRole(role);
	}
	
	public List<User> findByUser(String name) {
		logger.info("inside findByUser() - user service");
		return userRepo.findByUsername(name);
	}

	public List<User> findByRoleSorted(String role) {
		logger.info("inside findByRoleSorted() - user service");
		return userRepo.findByRoleSorted(role);
	}
	public void addUser(User user) {
		userRepo.save(user);
	}

	public void removeUser(int id) {
		userRepo.deleteById(id);
	}

	public Optional<User> getUser(int id) {
		logger.info("inside getUser() - user service");
		return userRepo.findById(id);
	}

	public Optional<User> updateUser(User user2, int id) {
		Optional<User> existingUser = userRepo.findById(id);
		// User inputUser = null;
		imputUser.setId(id);
		imputUser.setPassword(user2.getPassword());
		imputUser.setRole(user2.getRole());
		imputUser.setUsername(user2.getUsername());
		userRepo.save(imputUser);
		return userRepo.findById(id);

	}
}
