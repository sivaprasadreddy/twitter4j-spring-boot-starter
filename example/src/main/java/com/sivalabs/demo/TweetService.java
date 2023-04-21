package com.sivalabs.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.v1.ResponseList;
import twitter4j.v1.Status;

@Service
public class TweetService {
	private final Twitter twitter;

	public TweetService(Twitter twitter) {
		this.twitter = twitter;
	}

	public List<String> getLatestTweets(){
		List<String> tweets = new ArrayList<>();
		try {
			ResponseList<Status> homeTimeline = twitter.v1().timelines().getHomeTimeline();
			for (Status status : homeTimeline) {
				tweets.add(status.getText());
			}
		} catch (TwitterException e) {
			throw new RuntimeException(e);
		}
		return tweets;
	}
}
