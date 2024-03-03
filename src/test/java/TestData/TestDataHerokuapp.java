package TestData;

import org.json.JSONObject;

public class TestDataHerokuapp {

    public int basariliStatusCode=200;


    /*
      equest body
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

       */


    public  JSONObject bookindatesOlusturJSON(){
        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin","2021-06-01");
        bookingdates.put("checkout","2021-06-10");

        return bookingdates;

    }

    public  JSONObject bookinOlusturJSON(){

        JSONObject booking=new JSONObject();

        booking.put("firstname","Ali");
        booking.put("lastname","Bak");
        booking.put("totalprice",500);
        booking.put("depositpaid",false);

        booking.put("bookingdates",bookindatesOlusturJSON());
        booking.put("additionalneeds","wi-fi");

        return booking;
    }

    public JSONObject expectedBodyOlusturJSON(){

        JSONObject expData=new JSONObject();
        expData.put("bookingid",24);
        expData.put("booking",bookinOlusturJSON());

        return expData;






    }


}
