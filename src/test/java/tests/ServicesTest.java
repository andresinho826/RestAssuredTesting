package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ServicesTest {
    @Test
    public  void getExample(){
        Response response;

        response = given().get("http://5d6fd3a8482b530014d2e8da.mockapi.io/mock/api/v1/users");
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test
    public  void postExample(){
        Response response;
        Map<String, String> user = new HashMap<>();
        user.put("first_name", "Andres");
        user.put("last_name", "Castillo");
        user.put("email", "Castillo@email.com");
        user.put("country", "COL");
        user.put("telephone", "2323232323");
        user.put("active", "true");
        user.put("job_title", "TAE");


        response = given().contentType("application/json").body(user).when()
                .post("http://5d6fd3a8482b530014d2e8da.mockapi.io/mock/api/v1/users");
        Assert.assertEquals(response.getStatusCode(), 201);

    }
}
