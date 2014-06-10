package com.thomas.myexample.email;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * @ClassName: SimpleMailService
 * @Description: 发送邮件
 * @author XuTao
 * @date 2014-4-9 上午11:01:12
 * 
 */
public class SimpleMailService {

	public static Logger log = LoggerFactory.getLogger(SimpleMailService.class);

	private JavaMailSender mailSender;
	private String textTemplate;

	/*
	 * 发送纯文本邮件
	 */
	public void sendNotifyMail(String userName, String email) {
		SimpleMailMessage smm = new SimpleMailMessage();
		// 此处from的邮箱地址必须和配置的登陆邮箱地址一样
		smm.setFrom("xutao6936@163.com");
		smm.setTo(email);
		smm.setSubject("用户注册通知");
		String content = String.format(textTemplate, userName, new Date());
		smm.setText(content);
		try {
			mailSender.send(smm);
			log.info("纯文本邮件发送到{}", StringUtils.join(smm.getTo(), ","));
		} catch (Exception e) {
			log.error("发送邮件失败，用户名为{}", userName, e);
		}
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setTextTemplate(String textTemplate) {
		this.textTemplate = textTemplate;
	}

}
