package com.sivalabs.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Siva
 *
 */
@ConfigurationProperties(prefix= Twitter4jProperties.TWITTER4J_PREFIX)
public class Twitter4jProperties {
	
	public static final String TWITTER4J_PREFIX = "twitter4j";

	/**
	 * Enables deubg output. Effective only with the embedded logger.
	 */
	private boolean debug = false;
	
	private final OAuth oauth = new OAuth();

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public OAuth getOauth() {
		return oauth;
	}

	public static class OAuth {

		/**
		 * OAuth consumer key.
		 */
		private String consumerKey;

		/**
		 * OAuth consumer secret.
		 */
		private String consumerSecret;

		/**
		 * OAuth access token.
		 */
		private String accessToken;

		/**
		 * OAuth access token secret.
		 */
		private String accessTokenSecret;
		
		public String getConsumerKey() {
			return consumerKey;
		}
		public void setConsumerKey(String consumerKey) {
			this.consumerKey = consumerKey;
		}
		public String getConsumerSecret() {
			return consumerSecret;
		}
		public void setConsumerSecret(String consumerSecret) {
			this.consumerSecret = consumerSecret;
		}
		public String getAccessToken() {
			return accessToken;
		}
		public void setAccessToken(String accessToken) {
			this.accessToken = accessToken;
		}
		public String getAccessTokenSecret() {
			return accessTokenSecret;
		}
		public void setAccessTokenSecret(String accessTokenSecret) {
			this.accessTokenSecret = accessTokenSecret;
		}
		
	}
}
