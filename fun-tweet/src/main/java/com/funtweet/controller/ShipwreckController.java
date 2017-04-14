package com.funtweet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.funtweet.model.Shipwreck;

/**
 * Test controller
 * @author Yasemin Alpay
 *
 */
@RestController
@RequestMapping("api/v1/shipwrecks")
public class ShipwreckController extends CRUDController<Shipwreck> {
	
	public ShipwreckController() { 
		
	}
	
}
