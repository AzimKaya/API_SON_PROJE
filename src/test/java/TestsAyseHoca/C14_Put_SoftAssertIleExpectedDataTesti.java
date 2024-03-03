package TestsAyseHoca;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C14_Put_SoftAssertIleExpectedDataTesti {

  /*
    https://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki
    body’ye sahip bir PUT request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

            Request Body
            {
                "status":"success",
                "data":{
                        "name":"Ahmet",
                        "salary":"1230",
                        "age":"44",
                        "id":40
                        }
            }

            Response Body

            {
            "status":"success",
            "data":{
                "status":"success",
                "data":{
                        "name":"Ahmet",
                        "salary":"1230",
                        "age":"44",
                        "id":40
                        }
                   },
            "message":"Successfully! Record has been updated."
            }
                 */

    @Test
    public void put01(){

        // 1 - Url ve Request Body hazirla

        String url = "https://dummy.restapiexample.com/api/v1/update/21";
        /*

          "status":"success",
                "data":{
                        "name":"Ahmet",
                        "salary":"1230",
                        "age":"44",
                        "id":40
         */
        JSONObject data=new JSONObject();

        data.put("name","Ahmet");
        data.put("salary","1230");
        data.put("age","44");
        data.put("id",40);

        JSONObject reqBody=new JSONObject();
        reqBody.put("status","success");
        reqBody.put("data",data);

        JSONObject exData=new JSONObject();
        exData.put("status","success");
        exData.put("data",reqBody);
        exData.put("message","Successfully! Record has been updated.");

        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).put(url);
        response.prettyPrint();
        // 4 - Assertion
        JsonPath respJp=response.jsonPath();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(respJp.get("status"),exData.get("status"));
        softAssert.assertEquals(respJp.get("message"),exData.get("message"));

        softAssert.assertEquals(respJp.get("data.data.name"),
                exData.getJSONObject("data").getJSONObject("data").get("name"));
        softAssert.assertEquals(respJp.get("data.data.id"),
                exData.getJSONObject("data").getJSONObject("data").get("id"));
        softAssert.assertEquals(respJp.get("data.data.salary"),
                exData.getJSONObject("data").getJSONObject("data").get("salary"));
        softAssert.assertEquals(respJp.get("data.data.age"),
                exData.getJSONObject("data").getJSONObject("data").get("age"));
        softAssert.assertEquals(respJp.get("data.status"),exData.getJSONObject("data").get("status"));

        softAssert.assertAll();


    }
}
