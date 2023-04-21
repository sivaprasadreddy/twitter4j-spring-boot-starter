# SpringBoot Starter for Twitter4J

## How to use?

1. Install the `twitter4j-spring-boot-starter` locally

    ```shell
    git clone https://github.com/sivaprasadreddy/twitter4j-spring-boot-starter.git
    cd twitter4j-spring-boot-starter
    ./mvnw clean install
    ```

2. Add **twitter4j-spring-boot-starter** by adding the following dependency.

    ```xml
    <dependency>
        <groupId>com.sivalabs</groupId>
        <artifactId>twitter4j-spring-boot-starter</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
    ```

3. Go to https://developer.twitter.com/, create an application and generate Keys and tokens

4. Configure your Twitter OAuth properties in **example/src/main/resources/application.properties**

Now you can run the application or tests as follows:

   ```shell
   cd example
   ./mvnw test
   ./mvnw spring-boot:run
   ```
