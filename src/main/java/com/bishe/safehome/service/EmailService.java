package com.bishe.safehome.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.bishe.safehome.bean.User;
import com.bishe.safehome.enums.EnvironmentType;

/**
 *@ClassName: EmailService
 *@Description: TODO
 *@author: 24662
 *@version: V1.0.0
 *@Date: 2019年4月14日下午12:32:33
 */
@Service
public class EmailService extends Thread{
	//用于给用户发送邮件的邮箱
	private String fromEmail="zhaoxinru0@sohu.com";
	//收件邮箱
	private String toEmail="15709447338@163.com";
	//邮箱用户名
	private String username="zhaoxinru0@sohu.com";
	//邮箱密码
	private String password="sunshine2019";
	//发送邮件的服务器地址
	private String host="smtp.sohu.com";
	
	private EnvironmentType environmentType;
	public EmailService(EnvironmentType environmentType) {
		this.environmentType=environmentType;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Properties properties=new Properties();
			properties.setProperty("mail.host", host);
			properties.setProperty("mail.transport.protocol", "smtp");
			properties.setProperty("mail.smtp.auth", "true");
			Session session=Session.getInstance(properties);
			session.setDebug(true);
			Transport transport=session.getTransport();
			transport.connect(host, username, password);
			Message message=createEmail(session, environmentType);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Message createEmail(Session session,EnvironmentType environmentType) throws AddressException, MessagingException {
		MimeMessage message=new MimeMessage(session);
		message.setFrom(new InternetAddress(fromEmail));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
		message.setSubject("家中环境异常，请及时查看！");
		String info=null;
		if (environmentType.getValue()==1) {
			info="家中温度异常，请及时查看！";
		} else if (environmentType.getValue()==2) {
			info="家中湿度异常，请及时查看！";
		}else if (environmentType.getValue()==3) {
			info="家中可燃气体浓度异常，请及时查看！";
		}else if (environmentType.getValue()==4) {
			info="房门被打开，如非本人操作，请注意查看家中实景！";
		}
		message.setContent(info, "text/html;charset=UTF-8");
		message.saveChanges();
		return message;
		
	}

}
