package Step;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;

public class stepDefinition {
	
	private final String BASE_URL="https://restassureddemo.com" ; // assumptions
	private String response ;
		
	@Given("call a rest end point for a given order")
	public void callRestEndPointForGivenOrder(String url)throws URISyntaxException
	{
		RestAssured.baseURI=BASE_URL ; 
		response = given().queryParam("order","398481")
					.when().get("/getNaceDetails")
					.then().extract().response().asString();
	}

	@Then("validate response for following fields")
	public void validateResponseForFollowingFields(DataTable responseData)
	{
		       
		        JsonPath js=new JsonPath(response);
		        String actualDesciption ="AGRICULTURE\n" +
		        		                  ", FORESTRY\n" +
		        		                  "AND FISHING";
		        String actualThisitemincludes="This section includes the exploitation of\n"+
		        		                      "vegetal and animal natural resources,\n"+
		        		                      "comprising the activities of growing of\n"+
		        		                      "crops, raising and breeding of animals,\n"+
		        		                      "harvesting of timber and other plants,\n"+
		        		                      "animals or animal products from a farm or\n"+
		        		                      "their natural habitats.";
		        String order=js.getString("Order");
		        int level=js.getInt("Level");
		        String code=js.getString("Code");
		        String parent=js.getString("Parent");
		        String expectedDescription=js.getString("Description");
		        String expectedThisitemincludes=js.getString("This item includes"); 
		        String thisitemalsoincludes=js.getString("This item also includes");
		        String rulings=js.getString("Rulings");
		        String thisitemexcludes=js.getString("This item excludes");
		        String referencetoISICRev=js.getString("Reference to ISIC Rev. 4");
		        List<Map<String,String>> data = responseData.asMaps(String.class,String.class);
		        Assert.assertEquals(order ,data.get(0).get("Order"));
		        Assert.assertEquals(level ,data.get(0).get("Level"));
		        Assert.assertEquals(code ,data.get(0).get("Code"));
		        Assert.assertEquals(parent ,data.get(0).get("Parent"));
		        Assert.assertEquals(expectedDescription ,actualDesciption);
		        Assert.assertEquals(actualThisitemincludes ,expectedThisitemincludes);
		        Assert.assertEquals(thisitemalsoincludes ,data.get(0).get("This item also includes"));
		        Assert.assertEquals(rulings ,data.get(0).get("Rulings"));
		        Assert.assertEquals(thisitemexcludes ,data.get(0).get("This item excludes"));
		        Assert.assertEquals(referencetoISICRev ,data.get(0).get("Reference to ISIC Rev. 4"));
	}
	
}
