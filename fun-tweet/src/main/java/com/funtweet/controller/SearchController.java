package com.funtweet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.funtweet.config.TwitterConfigurationBuilder;
import com.funtweet.model.Tweet;
import com.wordnik.swagger.annotations.ApiOperation;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;


/**
 * Searches tweets.
 * @author Yasemin Alpay
 *
 */
@RestController
@RequestMapping("api/v1/search")
public class SearchController {

	public static int DEFAULT_RESULT_COUNT = 100;

	@ApiOperation(value= "search", notes = "Searches tweets using twitter4j. Searches by query string. "
			+ "Example query string: keyword=Ortakoy&hashtag=kumpir&result_type=mixed&latitude=45&longitude=54")
	@RequestMapping(value = "/{queryString}", method = RequestMethod.GET)
	public List<Tweet> search(@PathVariable String queryString) throws TwitterException, IOException {

		TwitterFactory twitterFactory = new TwitterFactory(TwitterConfigurationBuilder.build());
		Twitter twitter = twitterFactory.getInstance();

		Query query = new Query();
		query.setQuery(queryString);
		//FIXME fix for advanced search. get query string from frontend		
		//SearchQueryParser.parse(queryString);
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
