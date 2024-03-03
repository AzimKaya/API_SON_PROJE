package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class S01_ResponceBodyTest {
    /*
   https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
   Json formatindaki body ile bir PUT request gonderdigimizde
           {
           "title":"Elif",
           "body":"Merhaba dünya",
           "userId":10,
           "id":70
           }
   donen Response'un,
       status code'unun 200,
       ve content type'inin application/json; charset=utf-8,
       ve Server isimli Header'in degerinin cloudflare,
       ve status Line'in HTTP/1.1 200 OK
       ve title'in "Elif"
       ve body attribute'unun "Merhaba dünya"
       ve userId'nin 10 oldugunu test edin
 */

@Test
    public void put01(){

    String url="https://jsonplaceholder.typicode.com/posts/70";

    JSONObject reqBody=new JSONObject();
    reqBody.put("title","Elif");
    reqBody.put("body","Merhaba dünya");
    reqBody.put("userId",10);
    reqBody.put( "id",70);

    Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).put(url);
    response.prettyPrint();

    response.then().assertThat().contentType("application/json;charset=utf-8").
            header("Server","cloudflare").statusCode(200).statusLine("HTTP/1.1 200 OK").
            body("title",equalTo("Elif")).body("body",equalTo("Merhaba dünya")).
            body("userId",equalTo(10));




    }

}
