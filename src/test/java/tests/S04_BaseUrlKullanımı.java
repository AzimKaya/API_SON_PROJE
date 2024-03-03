package tests;

import BaseURL.JsonPlaceHolderBaesUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.hamcrest.Matchers;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class S04_BaseUrlKullanımı extends JsonPlaceHolderBaesUrl {
//Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin

    /*
        1-  https://jsonplaceholder.typicode.com/posts endpointine bir GET
         request gonderdigimizde donen response'un status code'unun 200 oldugunu
         ve Response'ta ("title" degerlerinin) 100 kayit oldugunu test edin.
        */

    /*
        2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET
            request gonderdigimizde donen response'un status code'unun 200 oldugunu
            ve "title" degerinin "optio dolor molestias sit" oldugunu test edin
         */

     /*
        3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE
            request gonderdigimizde donen response'un status code'unun 200 oldugunu ve
            response body'sinin null oldugunu test edin
         */


    @Test
    public void get01(){

        specJsonPlace.pathParam("pp1","posts");

        Response response=given().spec(specJsonPlace).when().get("/{pp1}");

        response.then().assertThat().statusCode(200).body("title", hasSize(100));



    }
    @Test
    public void get02(){

        specJsonPlace.pathParams("pp1", "posts","pp2","44");
        Response response=given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");

        response.prettyPrint();
        response.
                then().
                assertThat().
                statusCode(200).
                body("title",equalTo("optio dolor molestias sit"));


    }

}
