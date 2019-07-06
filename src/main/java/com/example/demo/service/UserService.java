package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	public UserRepo userRepo;

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public void addUser(User user) {
		 userRepo.save(user);
	}

	public void removeUser(int id) {
		userRepo.deleteById(id);
	}

	public Optional<User> getUser(int id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id);
	}
}
