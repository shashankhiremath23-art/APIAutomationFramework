package tests;

import apis.GetPetsAPI;
import core.ResponseHandler;
import io.restassured.response.Response;
import org.apache.log4j.Priority;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DataProviderUtil;

public class GetPetsAPITests {

    @Test(priority = 1, dataProvider = "petsData", dataProviderClass = DataProviderUtil.class)
    public void getPetsAPITest(String userName,String expectedStatus,String expectedMessage){
        GetPetsAPI api = new GetPetsAPI();

        Response res = api.getPetsAPI(userName);

        res.then().log().all();
        ResponseHandler.validateStatus(res, Integer.parseInt(expectedStatus));
    }

    /*@Test(priority = 2)
    public void getPetsAPITest2(){
        GetPetsAPI getPetsAPI = new GetPetsAPI();

        Response res = getPetsAPI.getPetsAPI("shashak.hiremath");

        res.then().log().all();
        Assert.assertEquals(res.statusCode(), 404);
    }
    */

}
