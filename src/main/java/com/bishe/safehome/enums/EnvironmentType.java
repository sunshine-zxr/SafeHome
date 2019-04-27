package com.bishe.safehome.enums;

/**
 *@ClassName: environmentType
 *@Description: TODO
 *@author: 24662
 *@version: V1.0.0
 *@Date: 2019年4月26日下午5:18:14
 */

public enum EnvironmentType {
	
	TEMPERATURE(1,"tem","温度"),
	HUMIDITY(2,"hum","湿度"),
	SMOKE(3,"smoke","烟雾浓度"),
	DOOR(4,"door","门磁");
	
	private Integer value;
	private String code;
	private String name;
	private EnvironmentType(Integer value, String code, String name) {
		this.value = value;
		this.code = code;
		this.name = name;
	}
	private EnvironmentType() {
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	

}
