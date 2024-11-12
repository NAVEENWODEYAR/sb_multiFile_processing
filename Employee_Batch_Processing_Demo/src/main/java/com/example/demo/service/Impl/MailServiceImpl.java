package com.example.demo.service.Impl;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import com.example.demo.service.MailService;
/**
 * @author Naveen Wodeyar
 * @date 08-Nov-2024
 * @time 10:05:54 pm
 */
public class MailServiceImpl implements MailService{

	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(MailServiceImpl.class);
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public String sendMail() {
		return null;
	}
}
