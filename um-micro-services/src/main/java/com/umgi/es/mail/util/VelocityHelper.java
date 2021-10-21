package com.umgi.es.mail.util;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.ui.velocity.VelocityEngineFactory;
import org.springframework.ui.velocity.VelocityEngineUtils;

public class VelocityHelper {

	public static final String getContentFromTemplate(Map<String, Object> model, String templateName)
			throws VelocityException, IOException {
		StringBuffer content = new StringBuffer();
		try {
			VelocityEngineFactory velocityEngineFactory = new VelocityEngineFactory();
			Properties props = new Properties();
			props.put("resource.loader", "class");
			props.put("class.resource.loader.class",
					"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

			velocityEngineFactory.setVelocityProperties(props);
			VelocityEngine velocityEngine = velocityEngineFactory.createVelocityEngine();
			content.append(
					VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/templates/" + templateName, model));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content.toString();
	}
}
