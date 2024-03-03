package TestsAyseHoca;

import BaseURL.JsonPlaceHolderBaesUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.JesonPlaceRequestBodyPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_Put_PojoClass extends JsonPlaceHolderBaesUrl {

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

    Expected Body

    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */

    @Test
    public void put01(){

        specJsonPlace.pathParams("pp1","posts","pp2",70);

        JesonPlaceRequestBodyPojo reqBody=new JesonPlaceRequestBodyPojo("Ahmet","Merhaba",10,70);
        System.out.println("reqBody=" + reqBody);

        JesonPlaceRequestBodyPojo expBody=new JesonPlaceRequestBodyPojo("Ahmet","Merhaba",10,70);
        System.out.println("reqBody=" + reqBody);

        Response response=given().spec(specJsonPlace).contentType(ContentType.JSON)
                                       .when().body(reqBody).put("/{pp1}/{pp2}");

        response.prettyPrint();

        // 4 - Assertion

        // JsonPath respJP = response.jsonPath();
        // HashMap<String,Object> respMap = response.as(HashMap.class);

        JesonPlaceRequestBodyPojo respPojo=response.as(JesonPlaceRequestBodyPojo.class);
        JesonPlaceRequestBodyPojo jesonPlaceRequestBodyPojo=new JesonPlaceRequestBodyPojo();

        assertEquals( expBody.getTitle() ,respPojo.getTitle());
        assertEquals( expBody.getBody() ,respPojo.getBody());
        assertEquals( expBody.getId() ,respPojo.getId());
        assertEquals( expBody.getUserId() ,respPojo.getUserId());



    }



}
