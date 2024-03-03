package TestsAyseHoca;

import BaseURL.HerokuAppBaseurl;
import TestData.TestDataHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class C21_Post_TestDataKullanimi extends HerokuAppBaseurl {

 /*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip
    bir POST request gonderdigimizde donen response’un status kodunu ve id haric
    body'sinin asagidaki gibi oldugunu test edin.

	Request body
	      {
	      "firstname" : "Ali",
	      "lastname" : “Bak",
	      "totalprice" : 500,
	      "depositpaid" : false,
	      "bookingdates" : {
                      "checkin" : "2021-06-01",
                      "checkout" : "2021-06-10"
                        },
	      "additionalneeds" : "wi-fi"
	       }

	Expected Body
	{
    "bookingid":24,
    "booking":{
            "firstname":"Ali",
            "lastname":"Bak",
            "totalprice":500,
            "depositpaid":false,
            "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                            },
            "additionalneeds":"wi-fi"
               }
    }
     */

    @Test
    public void post01(){
        // 1 - Url ve Request Body hazirla

        specHerokuApp.pathParam("pp1","booking");
        TestDataHerokuapp testDataHerokuapp=new TestDataHerokuapp();
        JSONObject reqBody=testDataHerokuapp.bookinOlusturJSON();

        // 2 - Expected Data hazirla
        JSONObject expData=testDataHerokuapp.expectedBodyOlusturJSON();

        // 3 - Response'i kaydet

        Response response=given().spec(specHerokuApp).contentType(ContentType.JSON)
                .when().body(reqBody.toString()).post("/{pp1}");
        response.prettyPrint();

        JsonPath resJP=response.jsonPath();
        assertEquals(testDataHerokuapp.basariliStatusCode,response.getStatusCode());
        assertEquals(expData.getJSONObject("booking").get("firstname"),resJP.get("booking.firstname"));
        assertEquals(expData.getJSONObject("booking").get("lastname"),resJP.get("booking.lastname"));
        assertEquals(expData.getJSONObject("booking").get("totalprice"),resJP.get("booking.totalprice"));
        assertEquals(expData.getJSONObject("booking").get("depositpaid"),resJP.get("booking.depositpaid"));
        assertEquals(expData.getJSONObject("booking").get("additionalneeds"),resJP.get("booking.additionalneeds"));
        assertEquals(expData.getJSONObject("booking").get("additionalneeds"),resJP.get("booking.additionalneeds"));
        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                resJP.get("booking.bookingdates.checkin"));
        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                resJP.get("booking.bookingdates.checkout"));










    }


}
