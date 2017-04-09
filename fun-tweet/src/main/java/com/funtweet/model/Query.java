package com.funtweet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Query {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	Long userId;
	String description;
	String keyword;
	String hashtag;
	String tweetOwner;
	String resultType;
	String language;
	Double latitude;
	Double longitude;

	public Query() { 
		
	}
	
	public Query(Long id, Long userId, String description, String keyword, String hashtag, String tweetOwner,
			String resultType, String language, Double latitude, Double longitude) {
		super();
		this.id = id;
		this.userId = userId;
		this.description = description;
		this.keyword = keyword;
		this.hashtag = hashtag;
		this.tweetOwner = tweetOwner;
		this.resultType = resultType;
		this.language = language;
		this.latitude = latitude;
		this.longitude = longitude;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public String getTweetOwner() {
		return tweetOwner;
	}

	public void setTweetOwner(String tweetOwner) {
		this.tweetOwner = tweetOwner;
	}

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Query [id=" + id + ", userId=" + userId + ", description=" + description + ", keyword=" + keyword
				+ ", hashtag=" + hashtag + ", tweetOwner=" + tweetOwner + ", resultType=" + resultType + ", language="
				+ language + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}
