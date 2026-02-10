package core;

import io.restassured.response.Response;

public class ResponseHandler {


    public static String getValue(Response response, String path) {
        return response.jsonPath().getString(path);
    }


    public static void validateStatus(Response response, int code) {
        response.then().statusCode(code);
    }
}
