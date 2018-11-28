package ru.gorparkovki.MiniUniversity;

import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.config;
import static io.restassured.config.RedirectConfig.redirectConfig;
import static java.lang.Boolean.valueOf;
import static java.lang.System.getProperty;

/**
 * @author Timofei B.
 */
public class TestBase {

    @BeforeTest
    public void setUpRestAssured() {
        config = config()
                .redirect(redirectConfig()
                        .followRedirects(valueOf(getProperty("rest.client.follow.redirects"))));
    }
}
