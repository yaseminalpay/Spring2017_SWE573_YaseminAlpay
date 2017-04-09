package com.funtweet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String status;
	String name;
	String mail;
	String password;
	String twitterAccount;
	String avatar;
	
	public User() { 
		
	}
	
	public User(Long id, String status, String name, String mail, String password, String twitterAccount,
			String avatar) {
		super();
		this.id = id;
		this.status = status;
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.twitterAccount = twitterAccount;
		this.avatar = avatar;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getTwitterAccount() {
		return twitterAccount;
	}
	
	public void setTwitterAccount(String twitterAccount) {
		this.twitterAccount = twitterAccount;
	}
	
	public String getAvatar() {
		return avatar;
	}
	
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", status=" + status + ", name=" + name + ", mail=" + mail + ", password=" + password
				+ ", twitterAccount=" + twitterAccount + ", avatar=" + avatar + "]";
	}
	
}
