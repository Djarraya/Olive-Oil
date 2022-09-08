package com.info.service;

import java.util.List;
import java.util.Optional;

import com.info.model.User;

public interface UserService {
	
	public User findByEmail(String email);
	
	public void save(User user);
	/**
	public void update(User user);
	
	public void update2(User user,Product product);
	*/
	public List<User> findAllUser();
	
	public void deleteUser(long userId);
	
	public Optional<User> findById(long userId);
}
