package com.incubyte.gmail.configure;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Config {

	static JSONObject configProperties;

	private static final Logger logger = LoggerFactory.getLogger(Config.class);

	public static void loadConfig() {
		try {
			configProperties = new JSONObject(
					new String(Files.readAllBytes(Paths.get("src\\main\\resources\\Config.json"))));

		} catch (Exception e) {
			logger.error("Exception occurred while loading config.properties " + e.getMessage());
		}

	}

	public static String getBrowserName() {
		logger.info("fetching login url");
		return configProperties.getString("Browser");
	}
	

	public static String getGmailUrl() {
		logger.info("fetching login url");
		return configProperties.getJSONObject("pageUrl").getString("gmail");
	}

	public static String getUserName(String userName) {
		logger.info("Fetching userName from configuration file");
		return configProperties.getJSONObject("users").getJSONObject(userName).getString("username");
	}

	public static String getUserEmail(String userName) {
		logger.info("Fetching userName from configuration file");
		return configProperties.getJSONObject("users").getJSONObject(userName).getString("email");
	}

	public static String getPassword(String userName) {
		logger.info("fetching password from configuration file");
		return configProperties.getJSONObject("users").getJSONObject(userName).getString("password");
	}

	
	public static int getDefaultWait() {
		return configProperties.getInt("DefaultWait");
	}

}
