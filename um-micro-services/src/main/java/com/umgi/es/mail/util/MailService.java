package com.umgi.es.mail.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.velocity.exception.VelocityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.umgi.es.log.utils.LoggerUtil;

@Component
public class MailService {

	@Autowired
	private JavaMailSender javaMailSender;

	Logger logger = LogManager.getLogger(this.getClass());

	@Value("${from.email.address}")
	private String fromEmailAddress;

	@Autowired
	private LoggerUtil loggerUtil;

	String logMessage = "";
	Map<String, Object> logContent = new HashMap<String, Object>();
	public void sendEmail(MessageDetails mail) throws MessagingException, VelocityException, IOException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);


		helper.setFrom(fromEmailAddress);
		helper.setTo(mail.getToList());
		if (mail.getCcList() != null && mail.getCcList().length > 0) {

			helper.setCc(mail.getCcList());
		}
		helper.setSubject(mail.getSubject());
		if(mail.getEmailBody()!=null) {
			mail.setMailContent(mail.getEmailBody());
		}
		else {
			mail.setMailContent(VelocityHelper.getContentFromTemplate(mail.getTemplateModel(), mail.getTemplate()));

		}
		helper.setText(mail.getMailContent(), true);

		javaMailSender.send(message);// this command sents mail
		
		logMessage = "Email sent successfully";
		logContent = loggerUtil.getLogRelatedContentForService("", "", logMessage, null, "END", null,
				"SES","v1");
		logger.info(logContent);
	}



	public void sendEmailWithAttachment(MessageDetails messageDetails) throws MessagingException, IOException {
		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setTo(messageDetails.getToList());
		helper.setSubject(messageDetails.getSubject());
		helper.setFrom(fromEmailAddress);
		String text = VelocityHelper.getContentFromTemplate(messageDetails.getTemplateModel(),
				messageDetails.getTemplate());
		logger.debug(" \n \nFrom Velocity Context: " + text + "\n\n");
		helper.setText(text, true);
		helper.addAttachment(messageDetails.getAttachmentDescription(),
				new ClassPathResource(messageDetails.getAttachmentDetails()));
		javaMailSender.send(msg);
	}

}
