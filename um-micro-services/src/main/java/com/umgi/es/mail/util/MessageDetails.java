package com.umgi.es.mail.util;

import java.io.IOException;
import java.util.Map;

import org.apache.velocity.exception.VelocityException;
import org.springframework.stereotype.Component;

@Component
public class MessageDetails {

	private String[] toList;
	private String[] ccList;
	private StringBuffer message;
	private String subject;
	private String attachmentDescription;
	private String attachmentDetails;
	private String template;
	private String mailContent;
	private StringBuffer contentType;
	private String emailBody;
	
	

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

	public StringBuffer getContentType() {
		return contentType;
	}

	public void setContentType(StringBuffer message2) {
		this.contentType = message2;
	}

	public String getMailContent() {
		return mailContent;
	}

	public void setMailContent(String string) {
		this.mailContent = string;
	}

	private Map<String, Object> templateModel;

	public Map<String, Object> getTemplateModel() {
		return templateModel;
	}

	public void setTemplateModel(Map<String, Object> templateModel) {
		this.templateModel = templateModel;
	}

	/**
	 * @return the attachmentDetails
	 */
	public String getAttachmentDetails() {
		return attachmentDetails;
	}

	/**
	 * @param attachmentDetails the attachmentDetails to set
	 */
	public void setAttachmentDetails(String attachmentDetails) {
		this.attachmentDetails = attachmentDetails;
	}

	/**
	 * @return the attachmentDescription
	 */
	public String getAttachmentDescription() {
		return attachmentDescription;
	}

	/**
	 * @param attachmentDescription the attachmentDescription to set
	 */
	public void setAttachmentDescription(String attachment) {
		this.attachmentDescription = attachment;
	}

	/**
	 * @return the toList
	 */
	public String[] getToList() {
		return toList;
	}

	/**
	 * @param toList the toList to set
	 */
	public void setToList(String... toList) {
		this.toList = toList;
	}

	/**
	 * @return the message
	 */
	public StringBuffer getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 * @throws IOException
	 * @throws VelocityException
	 */
	public void setMessage(StringBuffer message) {
		this.message = message;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String senderMail) {
		this.subject = senderMail;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	/**
	 * @return the ccList
	 */
	public String[] getCcList() {
		return ccList;
	}

	/**
	 * @param ccList the ccList to set
	 */
	public void setCcList(String... ccList) {
		this.ccList = ccList;
	}

}
