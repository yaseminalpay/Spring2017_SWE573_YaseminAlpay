package com.funtweet;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.funtweet.controller.HomeController;

public class AppTest {
	@Test
	public void testApp() {
		HomeController hc = new HomeController();
		String result = hc.home();
		assertNotNull(result);
	}
}
