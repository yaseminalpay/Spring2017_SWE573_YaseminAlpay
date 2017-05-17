package com.funtweet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.funtweet.config.TwitterConfigurationBuilder;
import com.funtweet.model.Tweet;
import com.funtweet.util.Lang;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@RestController
@RequestMapping("api/v1/search")
public class SearchController {

	public static int DEFAULT_RESULT_COUNT = 100;

	@RequestMapping(method = RequestMethod.GET)
	public List<Tweet> listByKeyword() throws TwitterException, IOException {

		String keyword = "Ortaköy";
		TwitterFactory twitterFactory = new TwitterFactory(TwitterConfigurationBuilder.build());
		Twitter twitter = twitterFactory.getInstance();

		Query query = new Query(keyword).lang(Lang.ENGLISH);
		query.setCount(DEFAULT_RESULT_COUNT);

		QueryResult searchResult = twitter.search(query);
		List<Status> statusList = searchResult.getTweets();
		List<Tweet> tweetList = new ArrayList<Tweet>();

		for (Status status : statusList) {
			Tweet tweet = new Tweet();
			tweet.setContent(status.getText());
			tweetList.add(tweet);
		}

		return tweetList;

	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Tweet> search() throws TwitterException, IOException {

		String keyword = "Ortaköy";
		TwitterFactory twitterFactory = new TwitterFactory(TwitterConfigurationBuilder.build());
		Twitter twitter = twitterFactory.getInstance();

		Query query = new Query(keyword).lang(Lang.ENGLISH);
		query.setCount(DEFAULT_RESULT_COUNT);

		QueryResult searchResult = twitter.search(query);
		List<Status> statusList = searchResult.getTweets();
		List<Tweet> tweetList = new ArrayList<Tweet>();

		for (Status status : statusList) {
			Tweet tweet = new Tweet();
			tweet.setContent(status.getText());
			tweetList.add(tweet);
		}

		return tweetList;

	}

}
