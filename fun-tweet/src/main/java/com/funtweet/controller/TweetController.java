package com.funtweet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.funtweet.model.Tweet;


/**
 * Controls tweets saved by users to user's portfolio.
 * @author Yasemin Alpay
 *
 */
@RestController
@RequestMapping("api/v1/tweets")
public class TweetController extends CRUDController<Tweet> {
	
	public TweetController()
	{
		
	}

}

