package com.funtweet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.funtweet.model.Query;
import com.funtweet.repository.QueryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class QueryIntegrationTest {

	@Autowired
	private QueryRepository qr;
	
	@Test
	public void testFindAll() {
		List<Query> list = qr.findAll();
		assertThat(list.size(), is(greaterThanOrEqualTo(0)));
		
	}
	
}
