package TestsAyseHoca;

import BaseURL.JsonPlaceHolderBaesUrl;
import TestData.TestDataJsonPlace;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C22_Put_DeSerialization extends JsonPlaceHolderBaesUrl {

   /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
    body’e sahip bir PUT request yolladigimizda donen response’in
    response body’sinin asagida verilen ile ayni oldugunu test ediniz

    Request Body

        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }

    Expected Data :

        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */

    @Test
    public void put01(){
        // 1- Url ve request body hazirla
        specJsonPlace.pathParams("pp1","posts","pp2","70");

        TestDataJsonPlace testDataJsonPlace=new TestDataJsonPlace();
        HashMap<String,Object> reqBody=testDataJsonPlace.requestBodyOlusturMap();

        // 2 - Expected Data hazirla
        HashMap<String,Object> expData=testDataJsonPlace.requestBodyOlusturMap();

        // 3 - Response'i kaydet

        Response response=given().spec(specJsonPlace).contentType(ContentType.JSON)
                          .when().body(reqBody).put("/{pp1}/{pp2}");
        response.prettyPrint();
        // 4 - Assertion

        HashMap<String,Object> restpMap=response.as(HashMap.class);
        assertEquals(expData.get("title"),restpMap.get("title"));
        assertEquals(expData.get("body"),restpMap.get("body"));
        assertEquals(expData.get("userId"),restpMap.get("userId"));
        assertEquals(expData.get("id"),restpMap.get("id"));



    }


}
