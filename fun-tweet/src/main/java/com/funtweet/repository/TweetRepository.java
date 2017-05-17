package com.funtweet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.funtweet.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
	
}
