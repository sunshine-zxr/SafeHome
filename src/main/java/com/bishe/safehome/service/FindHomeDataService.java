package com.bishe.safehome.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bishe.safehome.bean.HomeData;
import com.bishe.safehome.dao.HomeDataDao;

/**
 *@ClassName: FindHomeDataService
 *@Description: TODO
 *@author: zhao xinru
 *@version: V1.0.0
 *@Date: 2019年3月30日下午4:23:30
 */
@Service
public class FindHomeDataService {
	@Resource
	HomeDataDao homeDataDao;
	public List<HomeData> findAllHomeData(){
		return homeDataDao.findAllHomeData();
	}

}
