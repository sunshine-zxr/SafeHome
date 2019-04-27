package com.bishe.safehome.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bishe.safehome.bean.User;
import com.bishe.safehome.exception.UserException;
import com.bishe.safehome.service.UserService;

/**
 *@ClassName: RegisterController
 *@Description: TODO
 *@author: 24662
 *@version: V1.0.0
 *@Date: 2019年3月31日下午8:11:34
 */
@Controller
public class RegisterController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value="Regist")
	public String register() {
		return "register";
	}
	
	@RequestMapping(value="register")
	public String registerSuccess(HttpServletRequest request,Model model) throws UserException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		User user=new User(username, password, email);
		try {
			userService.registerUser(user);
			return "login";
		} catch (UserException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
			return "register";
		}
	}
}
