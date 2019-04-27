package com.bishe.safehome.dao;

import org.springframework.stereotype.Repository;

import com.bishe.safehome.bean.User;

/**
 *@ClassName: UserDao
 *@Description: 用户验证dao层
 *@author: zhao xinru
 *@version: V1.0.0
 *@Date: 2019年3月30日下午12:52:47
 */
@Repository
public interface UserDao {
	//用户注册，增加用户
	public abstract void addUser(User user);
	//根据用户名查询用户是否存在
	public abstract User findUserByUsername(String username);

}
