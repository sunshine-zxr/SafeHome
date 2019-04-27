package com.safahome.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bishe.safehome.bean.HomeData;
import com.bishe.safehome.dao.HomeDataDao;

/**
 *@ClassName: TestSafeHome
 *@Description: TODO
 *@author: 24662
 *@version: V1.0.0
 *@Date: 2019年3月30日下午5:04:41
 */

public class TestSafeHome {
	@Test
	public void test() {
		//初始化容器
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		//获得bean
		HomeDataDao homeDataDao=applicationContext.getBean(HomeDataDao.class);
		//访问数据库
		List<HomeData> homeDatas=homeDataDao.findAllHomeData();
		for(HomeData homeData:homeDatas) {
			System.out.println(homeData);
		}
		assertNotNull(homeDatas);
	}

}
