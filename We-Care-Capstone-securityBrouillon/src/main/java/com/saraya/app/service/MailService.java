package com.saraya.app.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

// added manualy
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessage;

@Service
public class MailService {
	private final static Logger log;
	@Autowired
	private final JavaMailSender mailSender;
	
	@Async
	public void send(String to, String email) {
		try {
			MimeMessage mimeMesage = mailSender.createMimeMessage();
			MimeMessageHelper helper =new MimeMessageHelper(mimeMesage, "utf-8");
			helper.setText(email,true);
			helper.setTo(to);
			helper.setSubject("subscription for coaching");
			helper.setFrom("we.care@saraya.com");
			
		} catch(MessagingException ex) {
			log.error("email not Send");
		}
	}
	

}
