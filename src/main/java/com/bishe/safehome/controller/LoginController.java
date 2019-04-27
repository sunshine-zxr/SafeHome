package com.bishe.safehome.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bishe.safehome.bean.User;
import com.bishe.safehome.exception.UserException;
import com.bishe.safehome.service.UserService;

/**
 *@ClassName: LoginController
 *@Description: TODO
 *@author: 24662
 *@version: V1.0.0
 *@Date: 2019年3月31日下午8:10:59
 */
@Controller
public class LoginController {
	@Resource
	UserService userService;
	
	@RequestMapping(value="/Login")
	public String sayHello() {
		return "login";
	}
	
	@RequestMapping(value="login")
	public String login(Model model,HttpServletRequest request,HttpServletResponse response) throws UserException, ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		try {
			User user=userService.loginUser(username, password);
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			return "homedata";
		} catch (UserException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
			return "login";
		}
		
	}

}
