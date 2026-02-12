package core;

import config.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseAPI {

    protected RequestSpecification request;

    public BaseAPI() {

        request = RestAssured.given()
                .baseUri(ConfigManager.get("base.url")) // Default base URI
                .header("Content-Type", "application/json");
    }
}
