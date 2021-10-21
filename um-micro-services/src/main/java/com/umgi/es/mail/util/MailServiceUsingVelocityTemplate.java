
package com.umgi.es.mail.util;

import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;
import javax.mail.MessagingException;
import org.apache.velocity.exception.VelocityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class MailServiceUsingVelocityTemplate {

	@Value("${default.mail.to}")
	private String[] toAddress;

	@Value("${default.mail.cc}")
	private String ccAddress;
	
	@Value("${default.mail.subject}")
	private String emailSubject;

	@Autowired
	private MailService mailService;

	public void simpleMailService(EmailTemplate emailTemplate)
			throws VelocityException, MessagingException, IOException {

		if (emailTemplate != null) {

			MessageDetails messageDetails = new MessageDetails();

			HashMap<String, Object> model = new HashMap<String, Object>();
			if (emailTemplate.getMessageId() != null)
				model.put("MessageId", emailTemplate.getMessageId());
			else
				model.put("MessageId", "");

			if (emailTemplate.getErrorMessage() != null)
				model.put("ErrorMessage", emailTemplate.getErrorMessage());
			else
				model.put("ErrorMessage", "");

			if (emailTemplate.getResourceId() != null)
				model.put("ResourceId", emailTemplate.getResourceId());
			else
				model.put("ResourceId", "");

			if (emailTemplate.getResourceName() != null)
				model.put("ResourceName", emailTemplate.getResourceName());
			else
				model.put("ResourceName", "");

			if (emailTemplate.getCreatedUtc() != null)

				model.put("CreatedUtc", emailTemplate.getCreatedUtc());
			else
				model.put("CreatedUtc", Instant.now().toString());

			if (emailTemplate.getMachine() != null)
				model.put("Machine", emailTemplate.getMachine());
			else
				model.put("Machine", "");

			if (emailTemplate.getService() != null)
				model.put("Service", emailTemplate.getService());
			else
				model.put("Service", "");

			if (emailTemplate.getMessageAction() != null)
				model.put("MessageAction", emailTemplate.getMessageAction());
			else
				model.put("MessageAction", "");
			if (emailTemplate.getMessageSource() != null)
				model.put("MessageSource", emailTemplate.getMessageSource());
			else
				model.put("MessageSource", "");

			messageDetails.setTemplateModel(model);

			if (emailTemplate.getEmailTo() != null) {
				messageDetails.setToList(emailTemplate.getEmailTo());
			} else {
				messageDetails.setToList(toAddress);

			}
			if (emailTemplate.getEmailCC() != null) {
				messageDetails.setCcList(emailTemplate.getEmailCC());
			} else {
				if(!ccAddress.trim().isEmpty())
				messageDetails.setCcList(ccAddress);

			}
			
			if (emailTemplate.getEmailSubject() != null) {
				messageDetails.setSubject(emailTemplate.getEmailSubject() );
			} else {
				messageDetails.setSubject(emailSubject);
			}
			if (emailTemplate.getEmailBody() != null) {
				messageDetails.setEmailBody(emailTemplate.getEmailBody());
			} else {
				messageDetails.setTemplate("emailTemplate.vm");
			}

			
			mailService.sendEmail(messageDetails);

		}
	}

}
