package com.funtweet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.funtweet.controller.QueryController;
import com.funtweet.model.Query;
import com.funtweet.repository.QueryRepository;

public class QueryControllerTest {
	
	@InjectMocks
	private QueryController queryControllerMock;
	
	@Mock
	private QueryRepository queryRepoMock;
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getQueryTest()
	{
		Query query = new Query();
		query.setId(1L);
		when(queryRepoMock.findOne(1L)).thenReturn(query);
		
		query = queryControllerMock.get(1L);
		assertThat(query.getId(), is(1L));
	}

}
