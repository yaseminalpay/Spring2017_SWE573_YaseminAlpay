package com.funtweet.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterConfigurationBuilder {

	public static Configuration build() throws IOException {
		
		ConfigurationBuilder builder = new ConfigurationBuilder();
		
		builder.setDebugEnabled(true).setOAuthConsumerKey("")
				.setOAuthConsumerSecret("")
				.setOAuthAccessToken("")
				.setOAuthAccessTokenSecret("");
		return builder.build();
	}

	private TwitterConfiguration readConfig() throws IOException  {

		TwitterConfiguration configuration = new TwitterConfiguration();
		try {
			Properties prop = new Properties();
			String propFileName = "twitter.properties";

			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("Property file '" + propFileName + "' not found in the classpath");
			}

			configuration.setOAuthConsumerKey(prop.getProperty("OAuthConsumerKey"));
			configuration.setOAuthConsumerSecret(prop.getProperty("OAuthConsumerSecret"));
			configuration.setOAuthAccessToken(prop.getProperty("OAuthAccessToken"));
			configuration.setOAuthAccessTokenSecret(prop.getProperty("OAuthAccessTokenSecret"));
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
//			inputStream.close();
		}
		
		return configuration;
	}

}
