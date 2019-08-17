package com.mercury.SpringBootRESTDemo.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	// sub: 邮件主题，text: 内容
	
	@Autowired
	public JavaMailSender sender;
	
	public void sendEmail(String to, String sub, String text) {
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setTo(to);
		smm.setSubject(sub);
		smm.setText(text);
		sender.send(smm);
	}
	
	public void sendEmail(SimpleMailMessage smm) {
		sender.send(smm);
	}
}
