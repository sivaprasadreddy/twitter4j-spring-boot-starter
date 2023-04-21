package com.sivalabs.spring.boot.autoconfigure;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import twitter4j.Twitter;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Siva
 *
 */
class Twitter4jAutoConfigurationTest {

    private final ApplicationContextRunner contextRunner =
            new ApplicationContextRunner()
                .withConfiguration(AutoConfigurations.of(Twitter4jAutoConfiguration.class))
                .withPropertyValues(
                    "twitter4j.oauth.consumerKey=consumer-key",
                    "twitter4j.oauth.consumerSecret=consumer-secret",
                    "twitter4j.oauth.accessToken=access-token",
                    "twitter4j.oauth.accessTokenSecret=access-token-secret");

    @Test
    void testWithTwitter4jProperties() {
        this.contextRunner
            .run((context) -> {
                assertThat(context).hasSingleBean(Twitter.class);
            });
    }

}
