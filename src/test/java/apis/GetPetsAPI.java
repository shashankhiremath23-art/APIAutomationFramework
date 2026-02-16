package apis;

import config.ConfigManager;

import core.BaseAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetPetsAPI extends BaseAPI {



    public Response getPetsAPI(String userName) {

        logInfo("Calling GET USER API");

        overrideBaseURI(ConfigManager.get("pets.url"));

        return request()
                .pathParam("username", userName)
                .when()
                .get("/user/{username}")
                .then()
                .extract()
                .response();
    }

}
