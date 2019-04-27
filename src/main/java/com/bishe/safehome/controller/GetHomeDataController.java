package com.bishe.safehome.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bishe.safehome.bean.HomeData;
import com.bishe.safehome.service.FindHomeDataService;

/**
 *@ClassName: GetHomeDataController
 *@Description: TODO
 *@author: zhao xinru
 *@version: V1.0.0
 *@Date: 2019年3月30日下午2:28:26
 */
@Controller
@RequestMapping("/HomeData")
public class GetHomeDataController {
	
	@Resource
	FindHomeDataService findHomeDataService;
	
	@RequestMapping("/show.do")
	public String getAllHomeData(Model model) {
		List<HomeData> homeDatas=findHomeDataService.findAllHomeData();
		System.out.println(homeDatas);
		LinkedList<HomeData> homeDataLinked=new LinkedList<>(homeDatas);
		while(homeDataLinked.size()>40) {
			homeDataLinked.removeFirst();
		}
		System.out.println(homeDataLinked);
		model.addAttribute("homeDatas",homeDataLinked);
		return "homedata";
	}

}
