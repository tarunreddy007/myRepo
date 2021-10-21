package com.umgi.es.mail.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailTemplate {

	@JsonProperty("MessageId")
	private String messageId;
	@JsonProperty("ErrorMessage")

	private String errorMessage;
	@JsonProperty("ResourceId")

	private String resourceId;
	@JsonProperty("ResourceName")

	private String resourceName;
	@JsonProperty("CreatedUtc")

	private String createdUtc;
	@JsonProperty("Machine")

	private String machine;
	@JsonProperty("Service")

	private String service;
	@JsonProperty("MessageAction")

	private String messageAction;
	@JsonProperty("MessageSource")
	private String messageSource;
	
	@JsonProperty("emailTo")
	private String emailTo;
	@JsonProperty("emailCC")
	private String emailCC;
	@JsonProperty("emailBcc")
	private String emailBCC;
	@JsonProperty("emailSubject")
	private String emailSubject;
	@JsonProperty("emailBody")
	private String emailBody;

	

	public EmailTemplate(String messageId, String errorMessage, String resourceId, String resourceName,
			String createdUtc, String machine, String service, String messageAction, String messageSource,
			String emailTo, String emailCC, String emailBCC, String emailSubject, String emailBody) {
		super();
		this.messageId = messageId;
		this.errorMessage = errorMessage;
		this.resourceId = resourceId;
		this.resourceName = resourceName;
		this.createdUtc = createdUtc;
		this.machine = machine;
		this.service = service;
		this.messageAction = messageAction;
		this.messageSource = messageSource;
		this.emailTo = emailTo;
		this.emailCC = emailCC;
		this.emailBCC = emailBCC;
		this.emailSubject=emailSubject;
		this.emailBody=emailBody;
	}

	public EmailTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getCreatedUtc() {
		return createdUtc;
	}

	public void setCreatedUtc(String createdUtc) {
		this.createdUtc = createdUtc;
	}

	public String getMachine() {
		return machine;
	}

	public void setMachine(String machine) {
		this.machine = machine;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getMessageAction() {
		return messageAction;
	}

	public void setMessageAction(String messageAction) {
		this.messageAction = messageAction;
	}

	public String getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(String messageSource) {
		this.messageSource = messageSource;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getEmailCC() {
		return emailCC;
	}

	public void setEmailCC(String emailCC) {
		this.emailCC = emailCC;
	}

	public String getEmailBCC() {
		return emailBCC;
	}

	public void setEmailBCC(String emailBCC) {
		this.emailBCC = emailBCC;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

	@Override
	public String toString() {
		return "EmailTemplate [messageId=" + messageId + ", errorMessage=" + errorMessage + ", resourceId=" + resourceId
				+ ", resourceName=" + resourceName + ", createdUtc=" + createdUtc + ", machine=" + machine
				+ ", service=" + service + ", messageAction=" + messageAction + ", messageSource=" + messageSource
				+ ", emailTo=" + emailTo + ", emailCC=" + emailCC + ", emailBCC=" + emailBCC + ", emailSubject="
				+ emailSubject + ", emailBody=" + emailBody + "]";
	}
	
	

}
