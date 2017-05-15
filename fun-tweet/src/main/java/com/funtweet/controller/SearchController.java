package com.funtweet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.funtweet.model.SavedTweet;
import com.funtweet.util.Lang;
import com.funtweet.util.TwitterConfigurationBuilder;

import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@RestController
@RequestMapping("api/v1/search")
public class SearchController {
	
	public static int DEFAULT_RESULT_COUNT = 100;

//	@RequestMapping(value = "/{keyword}", method = RequestMethod.GET)
	public void list(@PathVariable String keyword) throws TwitterException, IOException {
		String queryString = "Ortaköy";
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("7CTNRTN2ADGhNj1HUBmZRuXDF")
				.setOAuthConsumerSecret("8J2pdP513RAXgeDR4oSOg4mWIJq4CPkqnhdfl2Gqy5VamFtkN4")
				.setOAuthAccessToken("862759532828782592-txoMkPu66qbItp4EnBDIrHrsUqI5kgD")
				.setOAuthAccessTokenSecret("rL8lhhiXXD8hmiW98l89W2JLwzY8ptFpdCTkiel0bcY0D");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();

		Query query = new Query(queryString).lang("tr");
//		query.setResultType(ResultType.popular);
		query.setCount(100);
		
		GeoLocation location = new GeoLocation(29.026221, 41.047737);
		query.setGeoCode(location, 20, Query.KILOMETERS);
		QueryResult searchResult = twitter.search(query);
		List<Status> tweets = searchResult.getTweets();
		
		for (Status status : tweets) {
			System.out.println(status.getText());
			System.out.println("------------");
		}
	}

	// apps.twitter.com
	// FunTweetFTW / funfun574
	
	@RequestMapping(method = RequestMethod.GET)
	public List<SavedTweet> listByKeyword() throws TwitterException, IOException {

		String keyword = "Ortaköy";
		TwitterFactory twitterFactory = new TwitterFactory(TwitterConfigurationBuilder.build());
		Twitter twitter = twitterFactory.getInstance();
		
		Query query = new Query(keyword).lang(Lang.ENGLISH);
		query.setCount(DEFAULT_RESULT_COUNT);
		
		QueryResult searchResult = twitter.search(query);
		List<Status> statusList = searchResult.getTweets();
		List<SavedTweet> tweetList = new ArrayList<SavedTweet>();
		
		for (Status status : statusList) {
			SavedTweet tweet = new SavedTweet();
			tweet.setContent(status.getText());
			tweetList.add(tweet);
		}
		
		return tweetList;
		
	}
	
	// apps.twitter.com
	// FunTweetFTW / funfun574
}
