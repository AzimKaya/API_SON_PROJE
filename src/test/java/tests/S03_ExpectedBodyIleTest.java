package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class S03_ExpectedBodyIleTest {

   /*
http://dummy.restapiexample.com/api/v1/update/21 url'ine asagidaki
body'ye sahip bir PUT request gonderdigimizde donen response'un asagidaki gibi oldugunu test edin.
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

        String url="http://dummy.restapiexample.com/api/v1/update/21";

        JSONObject innerdata= new JSONObject();
        JSONObject reqbody= new JSONObject();

        innerdata.put("name","Ahmet");
        innerdata.put( "salary",1230);
        innerdata.put( "age",44);
        innerdata.put( "id",40);

        reqbody.put("status","success");
        reqbody.put("data",innerdata);

        JSONObject expdata=new JSONObject();
        expdata.put("status","success");
        expdata.put("data",reqbody);
        expdata.put("message","Successfully! Record has been updated.");

        Response response=given().contentType(ContentType.JSON).
                when().
                body(reqbody.toString()).
                put(url);

        //Assertion
        JsonPath resjpath=response.jsonPath();

        assertEquals(expdata.get("status"),resjpath.get("status"));
        assertEquals(expdata.get("message"),resjpath.get("message"));
        assertEquals(expdata.getJSONObject("data").getJSONObject("data").get("name"),resjpath.get("data.data.name"));
        assertEquals(expdata.getJSONObject("data").getJSONObject("data").get("id"),resjpath.get("data.data.id"));
        assertEquals(expdata.getJSONObject("data").getJSONObject("data").get("salary"),resjpath.get("data.data.salary"));
        assertEquals(expdata.getJSONObject("data").getJSONObject("data").get("age"),resjpath.get("data.data.age"));
        assertEquals(expdata.getJSONObject("data").get("status"),resjpath.get("data.status"));





    }

}
