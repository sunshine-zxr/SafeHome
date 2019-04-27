package com.bishe.safehome.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bishe.safehome.bean.User;
import com.bishe.safehome.dao.UserDao;
import com.bishe.safehome.exception.UserException;
import com.bishe.safehome.util.MD5;

/**
 *@ClassName: UserService
 *@Description: TODO
 *@author: 24662
 *@version: V1.0.0
 *@Date: 2019年3月31日上午8:55:30
 */
@Service
public class UserService {
	@Resource
	UserDao userDao;
	
	public void registerUser(User user) throws UserException {
		if(user!=null) {
			String username=user.getUsername();
			User user2=userDao.findUserByUsername(username);
			if(user2==null) {
				userDao.addUser(user);
				throw new UserException("注册成功，请返回登录！");
			}
			throw new UserException("用户名已存在");
		}	
	}
	
	public User loginUser(String username,String password) throws UserException{
		User user=userDao.findUserByUsername(username);
		if(user!=null) {
			if(user.getPassword().equals(MD5.getMD5Str(password))) {
				return user;
			}
			throw new UserException("密码不正确");
		}
		throw new UserException("用户不存在");
	}

}
