package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	// Custom Function based on Role
	public List<User> findByRole(String role);

	public List<User> findByUsername(String name);
	
	@Query("from user where role=?1 order by username desc")
	public List<User> findByRoleSorted(String role);

}
