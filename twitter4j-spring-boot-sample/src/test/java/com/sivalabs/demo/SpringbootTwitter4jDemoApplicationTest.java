/**
 * 
 */
package com.sivalabs.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import twitter4j.TwitterException;

/**
 * @author Siva
 *
 */
@SpringBootTest
public class SpringbootTwitter4jDemoApplicationTest  {


	@Autowired
	private TweetService tweetService;
	
	@Test
	public void testGetTweets() throws TwitterException {
		List<String> tweets = tweetService.getLatestTweets();
		for (String tweet : tweets) {
			System.err.println(tweet);
		}
	}

}
