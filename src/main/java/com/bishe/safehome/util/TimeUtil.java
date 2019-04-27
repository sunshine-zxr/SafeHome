package com.bishe.safehome.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *@ClassName: TimeUtil
 *@Description: TODO
 *@author: 24662
 *@version: V1.0.0
 *@Date: 2019年4月27日下午6:24:57
 */

public class TimeUtil {
	
	public Date getBeforeSecondTime() throws ParseException {
		//获取当前时间
		Date date=new Date();
		Calendar calendar=new GregorianCalendar();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, -1);
		//获取前1秒时间
		Date beforeSecondTime=dateFormat.parse(dateFormat.format(calendar.getTime()));
		return beforeSecondTime;
	}

}
