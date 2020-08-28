/**
 *
 */
package com.sivalabs.spring.boot.autoconfigure;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Siva
 *
 */
class Twitter4jAutoConfigurationTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(Twitter4jAutoConfiguration.class));

    @Test
    public void testWithTwitter4jProperties() {
        this.contextRunner
                .run((context) -> {
                    assertThat(context).hasSingleBean(Twitter4jProperties.class);
                    Twitter4jProperties properties = context.getBean(Twitter4jProperties.class);
                    assertThat(properties.getOauth().getAccessToken()).isEqualTo("access-token-value-here");
                });
    }

}
