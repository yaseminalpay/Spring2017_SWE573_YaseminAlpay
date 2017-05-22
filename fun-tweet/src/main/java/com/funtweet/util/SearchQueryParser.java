package com.funtweet.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.Query.ResultType;
import twitter4j.Query.Unit;


/**
 * Parses query string and return query object to issue search in twitter.
 * @author Yasemin Alpay
 *
 */
public class SearchQueryParser {

	public static Query parse(final String queryString) {
		
		Query query = new Query();

		String[] pairs = queryString.split("&");
		Double latitude = 0.0;
		Double longitude = 0.0;
		boolean hasLocation = false;
		
		for (String pair : pairs) {
			Matcher m = Pattern.compile("(\\S+)=(\\S*)").matcher(pair);
			while (m.find()) {
				
				String key = m.group(1);
				String value = m.group(2).replaceAll("%20", " ");

				if ("keyword".equals(key)) {
					query.setQuery(value);
				}
				if ("hashtag".equals(key)) {
					query.setQuery(query.getQuery().concat(" #" + value));
				}
				if ("result_type".equals(key)) {
					if("mixed".equals(value))
					{
						query.setResultType(ResultType.mixed);
					}
					if("recent".equals(value))
					{
						query.setResultType(ResultType.recent);
					}
					if("popular".equals(value))
					{
						query.setResultType(ResultType.popular);
					}
				}
				if ("latitude".equals(key)) {
					hasLocation = true;
					latitude = Double.parseDouble(value);
				}
				if ("longitude".equals(key)) {
					hasLocation = true;
					longitude = Double.parseDouble(value); 
				}
				if ("lang".equals(key)) {
					query.setLang(value);
				}
				
				if(hasLocation)
				{
					query.setGeoCode(new GeoLocation(latitude, longitude), 20, Unit.km);
				}
			}
		}
		
		if(query.getLang() == null)
		{
			query.setLang(Lang.ENGLISH);
		}
		return query;
	}
	
	
	
}
