package TestsAyseHoca;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C07_Get_BodyTekrarlarındanKurtulma {
    /*
                   https://restful-booker.herokuapp.com/booking/10 url’ine
                   bir GET request gonderdigimizde donen Response’un,

                   status code’unun 200,
                   ve content type’inin application/json; charset=utf-8,
                   ve response body’sindeki
                       "firstname“in,"Mark",
                       ve "lastname“in, "Jackson",
                       ve "totalprice“in, 560,
                       ve "depositpaid“in,false,
                       ve "additionalneeds“in,"Breakfast"
                   oldugunu test edin
            */
@Test
    public void get01(){

      String url="https://restful-booker.herokuapp.com/booking/10";

    Response response=given().when().get(url);

    response.prettyPrint();

    response.then()
            .assertThat()
            .statusCode(200)
            .contentType("application/json; charset=utf-8")
            .body("firstname", Matchers.equalTo("Jim"),
             "lastname",Matchers.equalTo("Jackson"),
                    "totalprice",Matchers.equalTo(560),
                    "totalprice",Matchers.equalTo(false),
                    "additionalneeds",Matchers.equalTo("Breakfast"));




    }


}
