package TestData;

import java.util.HashMap;

public class TestDataDummy {

    public int basariliStatusCodu=200;
    public String contecnType="application/json";


    public HashMap dataBodyOlustur(){

        /*

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

        HashMap<String,Object>data=new HashMap<>();
        data.put("id",3.0);
        data.put("employee_name","Ashton Cox");
        data.put("employee_salary",86000.0);
        data.put("employee_age",66.0);
        data.put("profile_image","");

        return data;
    }

    public  HashMap expectedBodyOlusturMap(){

        HashMap<String,Object>expBody=new HashMap<>();
        expBody.put("status","success");
        expBody.put("data",dataBodyOlustur());
        expBody.put("message","Successfully! Record has been fetched.");


        return expBody;
    }


}
