package com.funtweet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.funtweet.model.Query;

/**
 * Controls search queries, saved by users.
 * @author Yasemin Alpay
 *
 */

@RestController
@RequestMapping("api/v1/queries")
public class QueryController extends CRUDController<Query>{
	
	public QueryController() { 
		
	}
	
}
