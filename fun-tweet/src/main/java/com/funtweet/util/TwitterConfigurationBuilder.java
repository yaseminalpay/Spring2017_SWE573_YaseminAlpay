package com.funtweet.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterConfigurationBuilder {

	public static Configuration build() throws IOException {
		
		ConfigurationBuilder builder = new ConfigurationBuilder();
		InputStream inputStream = null;
		
		try {
			Properties properties = new Properties();
			String propertiesFileName = "/twitter.properties";

			inputStream = TwitterConfigurationBuilder.class.getResourceAsStream(propertiesFileName);

			if (inputStream != null) {
				properties.load(inputStream);
			} 
			else {
				throw new FileNotFoundException("Property file '" + propertiesFileName + "' not found in the resources.");
			}

			builder.setDebugEnabled(true)
			.setOAuthConsumerKey(properties.getProperty("OAuthConsumerKey"))
			.setOAuthConsumerSecret(properties.getProperty("OAuthConsumerSecret"))
			.setOAuthAccessToken(properties.getProperty("OAuthAccessToken"))
			.setOAuthAccessTokenSecret(properties.getProperty("OAuthAccessTokenSecret"));
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		
		return builder.build();
	}
}
