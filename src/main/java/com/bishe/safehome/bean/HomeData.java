package com.bishe.safehome.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *@ClassName: HomeData
 *@Description: 家居环境数据
 *@author: zhao xinru
 *@version: V1.0.0
 *@Date: 2019年3月30日上午11:21:15
 */

public class HomeData implements Serializable{
	
	/**
	 * @Fields serialVersionUID:TODO
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer hum;
	private Integer tem;
	private Integer smoke;
	private String door; 
	private Timestamp date;
	public HomeData(Integer id, Integer hum, Integer tem, Integer smoke, String door, Timestamp date) {
		super();
		this.id = id;
		this.hum = hum;
		this.tem = tem;
		this.smoke = smoke;
		this.door = door;
		this.date = date;
	}
	public HomeData() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getHum() {
		return hum;
	}
	public void setHum(Integer hum) {
		this.hum = hum;
	}
	public Integer getTem() {
		return tem;
	}
	public void setTem(Integer tem) {
		this.tem = tem;
	}
	public Integer getSmoke() {
		return smoke;
	}
	public void setSmoke(Integer smoke) {
		this.smoke = smoke;
	}
	public String getDoor() {
		return door;
	}
	public void setDoor(String door) {
		this.door = door;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "HomeData [id=" + id + ", hum=" + hum + ", tem=" + tem + ", smoke=" + smoke + ", door=" + door
				+ ", date=" + date + "]";
	}
}
