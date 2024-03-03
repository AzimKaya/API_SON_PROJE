package tests;

import BaseURL.JsonPlaceHolderBaesUrl;
import TestData.JsonPlaceHolderTesData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class S05_TestDataKullanımı extends JsonPlaceHolderBaesUrl {
    /*
https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET
request yolladigimizda donen response'in status kodunun 200 ve
response body'sinin asagida verilen ile ayni oldugunu test ediniz
 Response body :
  {
  "userId":3,
  "id":22,
  "title":"dolor sint quo a velit explicabo quia nam",
  "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
  um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
  }
   */

   @Test
    public  void get01(){

      specJsonPlace.pathParams("pp1","posts","pp2",22);

      JSONObject expData= JsonPlaceHolderTesData.expectedBodyOlusturJSON();

      Response repsonse=given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");

      JsonPath resJPath=repsonse.jsonPath();

      assertEquals(JsonPlaceHolderTesData.basariliStatusCode,repsonse.getStatusCode());
      assertEquals(expData.getInt("userId"),resJPath.getInt("userId"));
      assertEquals(expData.getInt("id"),resJPath.getInt("id"));
      assertEquals(expData.getString("title"),resJPath.getString("title"));
      assertEquals(expData.getString("body"),resJPath.getString("body"));




   }



}
