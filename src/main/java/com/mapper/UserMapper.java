package com.mapper;

import com.pojo.User;

import java.util.List;

public interface UserMapper {
    //根据姓名查询User
    public List<User> findUserByName(User user) throws Exception;

    public User queryUserById(int id) throws Exception;

    public int updateUserById(User user) throws Exception;
}
