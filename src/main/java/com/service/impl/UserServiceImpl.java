package com.service.impl;

import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> findUserByName(User user) throws Exception {

		return userMapper.findUserByName(user);
	}

	@Override
	public User queryUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.queryUserById(id);
	}

	@Override
	public int updateUserById(User user) throws Exception {
		
		return userMapper.updateUserById(user);
	}

}
