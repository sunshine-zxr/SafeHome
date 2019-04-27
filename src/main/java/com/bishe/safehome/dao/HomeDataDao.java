package com.bishe.safehome.dao;

import java.sql.Timestamp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bishe.safehome.bean.HomeData;

/**
 *@ClassName: HomeDataDao
 *@Description: 家居环境数据dao层
 *@author: zhao xinru
 *@version: V1.0.0
 *@Date: 2019年3月30日下午12:47:32
 */
@Repository
public interface HomeDataDao {
	//根据时间查询家居数据
	public HomeData findHomeDataByDate(Timestamp timestamp);
	//查询所有家居数据 
	public List<HomeData> findAllHomeData();

}
