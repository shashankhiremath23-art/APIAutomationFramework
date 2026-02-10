package core;

import config.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseAPI {

    protected RequestSpecification request;

    public BaseAPI() {
        RestAssured.baseURI = ConfigManager.get("base.url");
        request = RestAssured.given()
                .header("Content-Type", "application/json");
    }
}
