package com.funtweet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.funtweet.model.User;

/**
 * Controls user creation, update and delete.
 * @author Yasemin Alpay
 *
 */
@RestController
@RequestMapping("api/v1/users")
public class UserController extends CRUDController<User> {
	
	public UserController() { 
		
	}
	
}