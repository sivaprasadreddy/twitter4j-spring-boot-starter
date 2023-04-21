package com.sivalabs.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringBootTwitter4JDemoApplicationTest {

	@Autowired
	private TweetService tweetService;
	
	@Test
	public void testGetTweets() {
		List<String> tweets = tweetService.getLatestTweets();
		assertThat(tweets).isNotEmpty();
		for (String tweet : tweets) {
			System.out.println("==>"+tweet);
		}
	}
}
