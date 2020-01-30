package com.etm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

import com.etm.entity.Employee;

@Repository
public class NotificationServiceImple implements NotificationService {

	private JavaMailSender javamailsender;
	
	@Autowired
	public NotificationServiceImple(JavaMailSender javaMailSender) {
		this.javamailsender = javaMailSender;
	}
	@Override
	public void notify(Employee emp) {

			SimpleMailMessage mail = new SimpleMailMessage();
			mail.setTo(emp.getEmpEmail());
			mail.setFrom("etmcdac@gmail.com");
			mail.setSubject("Registeration confirmation");
			mail.setText("You are registered");
			javamailsender.send(mail);
		
	}

}
