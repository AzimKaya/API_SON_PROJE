package TestsAyseHoca;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.asserts.SoftAssert;
import static io.restassured.RestAssured.given;


public class C13_Get_SoftAssertIleExpectedDataTesti {
 /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

        Response Body
        {
        "status":"success",
        "data":{
                "id":3,
                "employee_name":"Ashton Cox",
                "employee_salary":86000,
                "employee_age":66,
                "profile_image":""
                },
        "message":"Successfully! Record has been fetched."
        }
     */

    @Test
    public void get01(){

        // 1 - Url hazirla

        String url = "http://dummy.restapiexample.com/api/v1/employee/3";

        // 2 - Expected Data hazirla

    /*
    {
        "status":"success",
        "data":{
                "id":3,
                "employee_name":"Ashton Cox",
                "employee_salary":86000,
                "employee_age":66,
                "profile_image":""
                },
        "message":"Successfully! Record has been fetched."
        }
     */

        JSONObject data=new JSONObject();
        data.put("id",3);
        data.put("employee_name","Ashton Cox");
        data.put("employee_salary",86000);
        data.put("employee_age",66);
        data.put("profile_image","");

        JSONObject exdata=new JSONObject();
        exdata.put("status","success");
        exdata.put("data",data);
        exdata.put("message","Successfully! Record has been fetched.");

        // 3 - Response'i kaydet
        Response response=given().when().get(url);
        response.prettyPrint();

        // 4 - Assertion
        SoftAssert softAssert=new SoftAssert();
        JsonPath restJP=response.jsonPath();

        softAssert.assertEquals(restJP.get( "status"),exdata.get("status"));
        softAssert.assertEquals(restJP.get( "message"),exdata.get("message"));
        softAssert.assertEquals(restJP.get("data.id"),exdata.getJSONObject("data").get("id"));
        softAssert.assertEquals(restJP.get("data.employee_name"),exdata.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(restJP.get("data.employee_salary"),exdata.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(restJP.get("data.employee_age"),exdata.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(restJP.get("data.profile_image"),exdata.getJSONObject("data").get("profile_image"));



        softAssert.assertAll();





    }
}
