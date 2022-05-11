package API.businessfn;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class APIUtils
{

    private Response response;

    private String Name = "Carbon credits";

    private boolean CanRelist = true;

    static final String JSON_PATH = "Promotions.findAll { it.Name == 'Gallery'}.Description[0]";

    public void con()
    {

        String Url = "https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false";
        RestAssured.baseURI = Url;
        RequestSpecification httpRequest = RestAssured.given();
        response = httpRequest.get();
        System.out.println(" response String -- >> " + response.getBody().asString());
    }

    public void acceptenceCriteriaValidation_StatusCode()
    {

        SoftAssert sAssert = new SoftAssert();
        sAssert.assertEquals(response.getStatusCode(), 200, " Status code ");
        sAssert.assertAll();
    }

    public void acceptenceCriteriaValidation_Name()
    {

        SoftAssert sAssert = new SoftAssert();
        JSONObject respJson = new JSONObject(response.asString());
        sAssert.assertEquals(respJson.getString("Name"), Name, "Carbon credits");
        sAssert.assertAll();
    }

    public void acceptenceCriteriaValidation_CanRelist()
    {

        SoftAssert sAssert = new SoftAssert();
        JSONObject respJson = new JSONObject(response.asString());
        sAssert.assertEquals(respJson.getBoolean("CanRelist"), CanRelist, " CanRelist ");
        sAssert.assertAll();
    }

    public void acceptenceCriteriaValidation_Description()
    {
        SoftAssert sAssert = new SoftAssert();
        JSONObject respJson = new JSONObject(response.asString());
        sAssert.assertEquals(respJson.getString("Name"), Name, "Gallery");
        JSONArray JSONarray = respJson.getJSONArray("Promotions");
        for (int i = 0; i < JSONarray.length(); i++) {
            JSONObject respJson2 = JSONarray.getJSONObject(i);
            int idno = respJson2.getInt("Id");
            if (idno == 2) {
                String name = respJson2.getString("Name");
                Assert.assertEquals(name, "Gallery", "Value match Name:Gallery ");
                String desc = respJson2.getString("Description");
                Assert.assertEquals(desc, "Good position in category", "Value matchs Good position in category");
            }
        }

    }
}
