package com.mkydy.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkydy.springboot.dao.UserMapper;
import com.mkydy.springboot.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserMapper userMapper;
	
	// http://localhost:8888/user/getUser?username=xiaoli2
	@GetMapping("/getUser")
	public String getUser(String username) {
		User user = userMapper.findUserByUsername(username);
		return user!=null?username+"的密码是："+user.getUser_password() : "不存在用户名为"+username+"的用户";	
	}
	
	//http://localhost:8888/user/updateUser?username=xiaoli2&password=123
    @RequestMapping("/updateUser")
    public String updateUser(String password,String username){
        User user = new User(username,password);
        userMapper.updateUserByUsername(user);
        return "success!";
    }


    //http://localhost:8888/user/addUser?username=xiaoli2&password=123
    @RequestMapping("/addUser")
    public String addUser(String username,String password){
        User user = new User(username,password);
        userMapper.saveUser(user);
        return "success!";
    }

    // http://localhost:8888/user/deleteUser?username=xiaoli2
    @RequestMapping("/deleteUser")
    public String deleteUser(String username){
        userMapper.deleteUserByUsername(username);
        return "success!";
    }

    // http://localhost:8888/user/getUserList
    @RequestMapping("/getUserList")
    public List<User> getUserList(String username, String password){
        return userMapper.getUserList();
    }
}
