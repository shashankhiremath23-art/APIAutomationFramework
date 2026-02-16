package core;

import config.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseAPI {
    protected static final Logger logger = LogManager.getLogger(BaseAPI.class);

    public BaseAPI() {
        // Initialize with default base URI from config
        initialize(ConfigManager.get("base.url"));
    }

    protected void initialize(String baseUri) {
        logger.info("Initializing Base URI: {}", baseUri);




        // We define a base specification that all requests will inherit
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setContentType(ContentType.JSON)
                .addFilter(new io.restassured.filter.log.RequestLoggingFilter())
                .addFilter(new io.restassured.filter.log.ResponseLoggingFilter())
                .build();
    }

    protected RequestSpecification request() {
        // Simply return the given() entry point.
        // It will automatically pick up the Global baseURI and requestSpecification set above.
        return RestAssured.given();
    }

    protected void overrideBaseURI(String newUri) {
        logger.info("Overriding Base URI: {}", newUri);
        initialize(newUri);
    }

    protected void logInfo(String msg) {
        logger.info(msg);
        // Ensure ExtentTestManager is properly initialized in your project to use this
        // ExtentTestManager.getTest().info(msg);
    }

    protected void logError(String msg) {
        logger.error(msg);
        // ExtentTestManager.getTest().fail(msg);
    }
}