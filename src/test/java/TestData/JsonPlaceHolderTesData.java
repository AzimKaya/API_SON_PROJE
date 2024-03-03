package TestData;
import org.json.JSONObject;
public class JsonPlaceHolderTesData {
    /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET
        request yolladigimizda donen response’in status kodunun 200 ve
        response body’sinin asagida verilen ile ayni oldugunu test ediniz
        Response body :
        {
            "userId":3,
                "id":22,
                "title":"dolor sint quo a velit explicabo quia nam",
                "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
            um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
        }
         */
    public static int basariliStatusCode=200;
    public static JSONObject expectedBodyOlusturJSON(){
        JSONObject expBodyJSON=new JSONObject();
        expBodyJSON.put("userId",3);
        expBodyJSON.put("id",22);
        expBodyJSON.put("title","dolor sint quo a velit explicabo quia nam");
        expBodyJSON.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");
        return expBodyJSON;
    }
}