package TestsAyseHoca;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JsonObjesiOlusturma {



    @Test
    public void  jsonObje01(){

/*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.

    {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":1
    }
    */

        JSONObject ilkJsonObje=new JSONObject();
        ilkJsonObje.put("title","Ahmet");
        ilkJsonObje.put("body","Merhaba");
        ilkJsonObje.put( "userId",1);

        System.out.println("İlk Json Objemiz:"+ilkJsonObje);

    }

    @Test
    public void  jsonObje02(){

       /*
                {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                                 },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
         */

        JSONObject jsonObjectDates=new JSONObject();

        jsonObjectDates.put("checkin","2018-01-01");
        jsonObjectDates.put("checkout","2019-01-01");

        JSONObject outherJson=new JSONObject();

        outherJson.put("firstname","Jim");
        outherJson.put("additionalneeds","Breakfast");
        outherJson.put("bookingdates",jsonObjectDates);
        outherJson.put("totalprice",111);
        outherJson.put("depositpaid",true);
        outherJson.put("lastname","Brown");

        System.out.println("Boking Json Objemiz:"+outherJson);









    }

}
