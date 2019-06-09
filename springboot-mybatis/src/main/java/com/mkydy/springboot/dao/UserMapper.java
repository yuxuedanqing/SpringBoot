package com.mkydy.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mkydy.springboot.entity.User;
@Mapper
public interface UserMapper {

	User findUserByUsername(String username);

    void updateUserByUsername(User user);

    void deleteUserByUsername(String username);

    void saveUser(User user);

    List<User> getUserList();
}
