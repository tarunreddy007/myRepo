package com.umgi.es.web;

import java.io.IOException;

import javax.mail.MessagingException;

import org.apache.velocity.exception.VelocityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.umgi.es.mail.util.EmailTemplate;
import com.umgi.es.mail.util.MailServiceUsingVelocityTemplate;

@RestController
public class UMRestController {
	@Autowired
	private MailServiceUsingVelocityTemplate mailServiceUsingVelocityTemplate;
	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}

	@RequestMapping("/")
	public String index() {
		return "Greetings from UM Mircor Services ! Please give specific micro service as path name to do respective operations ";
	}

	@RequestMapping(value = "/ses", method = RequestMethod.POST)
	public void callSES(@RequestBody EmailTemplate emailTemplate)
			throws VelocityException, MessagingException, IOException {

		mailServiceUsingVelocityTemplate.simpleMailService(emailTemplate);
	}

}