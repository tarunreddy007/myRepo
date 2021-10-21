package com.umgi.es.log.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class LoggerUtil{

	public Map<String, Object> getLogRelatedContentForService(String messageId, String Resource_id,
			String logMessage, String payload, String tracePoint, String exception, String serviceName, String appVersion)
			throws UnknownHostException {
		// TODO Auto-generated method stub
		Map<String, Object> logContent = new HashMap<>();

		logContent.put("appName", serviceName);
		logContent.put("appVersion", appVersion);
		logContent.put("env", "DEV");
		Map<String, String> properties = new HashMap<String, String>();
		properties.put("messageId", messageId);
		properties.put("resourceId", Resource_id);
		properties.put("resourceName", serviceName);
		properties.put("nodeName", InetAddress.getLocalHost().getHostName());
		logContent.put("timestamp", Instant.now().toString());

		logContent.put("ext", properties);

		Map<String, Object> logOnes = new HashMap<>();
		logOnes.put("correlationId", messageId);
		logOnes.put("message", logMessage);
		if (payload != null) {
			logOnes.put("payload", payload);
		}
		logOnes.put("tracePoint", tracePoint);
		logContent.put("log", logOnes);

		if (exception != null) {
			Map<String, Object> exceptionOnes = new HashMap<>();
			exceptionOnes.put("detail", exception);

			logContent.put("exception", exceptionOnes);
		}
		return logContent;
	}
}
