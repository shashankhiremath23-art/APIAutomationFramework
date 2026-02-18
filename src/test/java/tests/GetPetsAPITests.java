package tests;

import apis.GetPetsAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.DataProviderUtil;
import utilities.LoggerUtil;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class GetPetsAPITests extends GetPetsAPI {




    @Test(groups = "smoke", priority = 1, dataProvider = "petsData", dataProviderClass = DataProviderUtil.class)
    public void getPetsAPITest(String userName, String expectedStatus, String expectedMessage) {
        SoftAssert softAssert = new SoftAssert();
        logInfo("Starting GetPetsAPITest for user: " + userName);
        logInfo("Expected message: " + expectedMessage);


        Response res = getPetsAPI(userName);

        logInfo("API response received for user: " + userName + " with status code: " + res.getStatusCode());

        res.then().log().ifValidationFails();

        softAssert.assertEquals(res.statusCode(), Integer.parseInt(expectedStatus), "Wrong status code");
        logInfo("Response status matched");

        softAssert.assertTrue(res.getTime() < 3000, "Response time more than 3 seconds");
        logInfo("Response time within 3 seconds");
        softAssert.assertEquals(res.contentType(), "application/json", "Response content type mismatch!");
        logInfo("Response content type: " + res.contentType() + " is matched");

        if (res.getStatusCode() == 200) {
            try {
                res.then().assertThat().body(matchesJsonSchemaInClasspath("schemas/get-pets-schema.json"));
                logInfo("Schema validated");
            } catch (AssertionError e) {
                softAssert.fail(" [JSON Schema Validation Failed!] " + e.getMessage());
            }
        }

        softAssert.assertAll();
    }

}
