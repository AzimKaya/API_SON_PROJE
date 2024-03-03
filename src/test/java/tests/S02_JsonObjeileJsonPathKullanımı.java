package tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;


public class S02_JsonObjeileJsonPathKullanımı {
/*
    Verilen bilgileri türüne göre gruplayarak yazdirma islemi yapacagiz.
    Asagidaki gibi response elde edecegiz:
    {
"firstName":"Harika",
"lastName":"Wise",
"address":{
       "streetAddress":"Susam Sokagi",
       "city":"Ankara",
   "postalCode":"06100" },
"age":23,
"phoneNumbers":[
    {
       "number":"532-555 55 55",
      "type":"cep" },
    {
      "number":"0312-123 4567",
      "type":"ev " }
          ]
}
     */

   @Test
   public void test01(){

       //1-Önce gerekli objeleri olusturalim
       JSONObject kisibilgileri=new JSONObject();
       JSONObject adresbilgileri=new JSONObject();
       JSONObject evtel=new JSONObject();
       JSONObject ceptel=new JSONObject();

       JSONArray telbilgileri=new JSONArray();

       //2-Adres bilgilerini response olarak yazdirmak icin adres bilgisi objesine tanimlayalim
       adresbilgileri.put(	"streetAddress","Susam Sokagi");
       adresbilgileri.put("city","Ankara");
       adresbilgileri.put(	"postalCode","06100");

       //3- Telefon bilgilleri icin array olusturalim
       evtel.put("number","0312-123 4567");
       evtel.put("type","ev ");

       ceptel.put("number","532-555 55 55");
       ceptel.put("type","cep");

       telbilgileri.put(evtel);
       telbilgileri.put(ceptel);

       //3- Kisi bilgileri olusturalim
       kisibilgileri.put("firstName","Harika");
       kisibilgileri.put("lastName","Wise");
       kisibilgileri.put("age",23);
       kisibilgileri.put("address",adresbilgileri);
       kisibilgileri.put("phoneNumbers",telbilgileri);


       System.out.println(kisibilgileri);




   }


}
