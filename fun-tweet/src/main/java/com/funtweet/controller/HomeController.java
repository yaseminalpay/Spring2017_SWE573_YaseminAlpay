package com.funtweet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * For landing page.
 * @author Yasemin Alpay
 *
 */
@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String home()
	{
		return "Welcome to Fun tweets! Application is running.";
	}

}
