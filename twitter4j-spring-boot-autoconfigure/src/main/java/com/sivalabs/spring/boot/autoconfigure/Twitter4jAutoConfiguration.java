package com.sivalabs.spring.boot.autoconfigure;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.Twitter;

/**
 * @author Siva
 */
@Configuration
@ConditionalOnClass(Twitter.class)
@EnableConfigurationProperties(Twitter4jProperties.class)
public class Twitter4jAutoConfiguration {

    private static final Log log = LogFactory.getLog(Twitter4jAutoConfiguration.class);

    private final Twitter4jProperties properties;

    public Twitter4jAutoConfiguration(Twitter4jProperties twitter4jProperties) {
        this.properties = twitter4jProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    public Twitter twitter() {
        if (this.properties.getOauth().getConsumerKey() == null
                || this.properties.getOauth().getConsumerSecret() == null
                || this.properties.getOauth().getAccessToken() == null
                || this.properties.getOauth().getAccessTokenSecret() == null) {
            log.error("Twitter4j properties not configured properly. Please check twitter4j.* properties settings in configuration file.");
            throw new RuntimeException(
                    "Twitter4j properties not configured properly. Please check twitter4j.* properties settings in configuration file.");
        }
        return Twitter.newBuilder()
                .prettyDebugEnabled(properties.isDebug())
                .oAuthConsumer(properties.getOauth().getConsumerKey(),
                        properties.getOauth().getConsumerSecret())
                .oAuthAccessToken(properties.getOauth().getAccessToken(),
                        properties.getOauth().getAccessTokenSecret()).build();
    }

}
