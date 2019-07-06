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
	
	@Autowired
	User imputUser;
		

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

	public Optional<User> updateUser(User user2, int id) {	
		Optional<User> existingUser = userRepo.findById(id);
		//User inputUser = null;
		imputUser.setId(id);
		imputUser.setPassword(user2.getPassword());
		imputUser.setRole(user2.getRole());
		imputUser.setUser_name(user2.getUser_name());		
		userRepo.save(imputUser);
		return userRepo.findById(id);
		
	}
}
