package com.service;

import com.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
	// 根据姓名查询User
	public List<User> findUserByName(User user) throws Exception;
	public User queryUserById(int id) throws Exception;
	public int  updateUserById(User user) throws Exception;
}
