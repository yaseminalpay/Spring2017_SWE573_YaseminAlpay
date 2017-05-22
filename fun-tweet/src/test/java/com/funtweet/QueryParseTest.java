package com.funtweet;

import org.junit.Test;

import com.funtweet.util.SearchQueryParser;

public class QueryParseTest {
	
	@Test
	public void parseTest()
	{
		final String fullString = "keyword=Ortakoy&hashtag=kumpir&result_type=mixed&latitude=45&longitude=54";
		SearchQueryParser.parse(fullString);

		final String latitude = "keyword=Ortakoy&hashtag=kumpir&result_type=mixed&latitude=45";
		SearchQueryParser.parse(latitude);
		
		final String longitude = "keyword=Ortakoy&hashtag=kumpir&result_type=mixed&longitude=54&";
		SearchQueryParser.parse(longitude);
		
		final String and = "keyword=Ortakoy%20cami&hashtag=kumpir&result_type=mixed&latitude=45&longitude=54";
		SearchQueryParser.parse(and);
		
	}

}
