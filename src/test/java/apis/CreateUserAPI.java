package apis;

import config.ConfigManager;
import core.BaseAPI;
import io.restassured.response.Response;
import models.CreateUserRequest;

public class CreateUserAPI extends BaseAPI {

    public Response createUser(CreateUserRequest userPayload) {
        logInfo("Calling CREATE USER API");

        // Since the base URL is consistent across the petstore,
        // you can set it here if it's not already set in BaseAPI
        overrideBaseURI(ConfigManager.get("pets.url"));

        return request()
                .body(userPayload)
                .when()
                .post("/user")
                .then()
                .extract()
                .response();
    }


}
