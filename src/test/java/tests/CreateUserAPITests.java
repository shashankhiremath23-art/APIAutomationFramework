package tests;

import apis.CreateUserAPI;

import io.restassured.response.Response;
import models.CreateUserRequest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.DataProviderUtil;

public class CreateUserAPITests extends CreateUserAPI {



    @Test(dataProvider = "createUserData", dataProviderClass = DataProviderUtil.class)
    public void createUserAPITest(String id, String username, String firstName,
                                 String lastName, String email, String password,
                                 String phone, String userStatus) {
        SoftAssert softAssert = new SoftAssert();
        logInfo("Starting CreateUserAPITest for user: " + username);


        // 1. Map Excel row data to your POJO
        // Note: ExcelUtil often returns data as String, so we parse numeric values
        CreateUserRequest payload = CreateUserRequest.builder()
                .id(id)
                .username(username)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .phone(phone)
                .userStatus(userStatus)
                .build();

        logInfo("Payload: " + payload.toString() + "\n");

        // 2. Call the API client layer
        Response response = createUser(payload);
        logInfo("API response received for user: " + username + " with status code: " + response.getStatusCode());
        response.then().log().ifValidationFails();


        // 3. Validation
        softAssert.assertEquals(response.getStatusCode(), 200);
        //softAssert.assertEquals(response.jsonPath().getString("message"), id);
    }
}