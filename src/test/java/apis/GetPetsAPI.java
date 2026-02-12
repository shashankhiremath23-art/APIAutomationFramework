package apis;

import config.ConfigManager;

import core.BaseAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetPetsAPI extends BaseAPI {



    public Response getPetsAPI(String userName) {

        Response response = request
                .baseUri(ConfigManager.get("pets.URl"))
                .pathParam("userName", userName)
                .log().all()
                .get("/user/{userName}");

        return response;
    }
}
