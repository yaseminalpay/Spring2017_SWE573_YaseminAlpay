package com.funtweet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.funtweet.model.SavedTweet;

public interface SavedTweetRepository extends JpaRepository<SavedTweet, Long> {
	
}
