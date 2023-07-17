package basePackage;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import filesPackage.Payload;

public class Basics {

	public static void main(String[] args) {
		
		//*****************************************************************//
		//					Getting place ID	POST					   //	 
		//*****************************************************************//
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
				
		//given - all input details
		//when - submit the API ==> resource and http
		//then - validate the response
		
		String response =
		given().log().all()
			.queryParam("key", "qaclick123")
			.header("Content-Type", "application/json")
			.body(Payload.AddPlace())
		.when()
			.post("/maps/api/place/add/json")
		.then()
			.assertThat().statusCode(200)
			.body("scope", equalTo("APP"))   // use this package to solve the redline under body: import static org.hamcrest.Matchers.*;
			.header("Server", "Apache/2.4.52 (Ubuntu)")
			.extract().response().asString(); 
		
		System.out.println(">>> "+response);
		
		// now lets PARSE this json which we stored in response variable to get specific data
		// JasonPath is a class which takes String as an input and converts it into JSON
		
		JsonPath JP_obj1 = new JsonPath(response);
		
		//lets get id, id is a string, thus
		
		String placeId = JP_obj1.getString("place_id");
		
		System.out.println(">>> "+placeId);
		
		//*****************************************************************//
		//					       Updating place  		PUT				   //	 
		//*****************************************************************//
		String newAddress = "77 Park Avenue, NY";
		given()
			.log().all()
			.queryParam("key", "qaclick123")
			.header("Content-Type", "application/json")
			.body("{\n"
					+ "\"place_id\":\""+placeId+"\",\n"
					+ "\"address\":\""+newAddress+"\",\n"
					+ "\"key\":\"qaclick123\"\n"
					+ "}")
		.when()
			.put("/maps/api/place/update/json")
		.then()
			.log().all()
			.assertThat().statusCode(200)
			.body("msg", equalTo("Address successfully updated"));
		
		//*****************************************************************//
		//					       GET place  		     GET			   //	 
		//*****************************************************************//
		
		String getPlaceResponse = 
		given()
			.log().all()
			.queryParam("key", "qaclick123")
			.queryParam("place_id", placeId)
		.when()
			.get("/maps/api/place/update/json")
		.then()
			.log().all()
			.assertThat()
			.statusCode(200)
			.extract()
			.response()
			.asString();
		
		System.out.println(">>> getPlaceResponse: "+getPlaceResponse);
		JsonPath JP_obj2 = new JsonPath(getPlaceResponse);
		
		String expectedAddress = JP_obj2.getString("address");
		System.out.println(">>> Expected Address: "+ expectedAddress);
		Assert.assertEquals(expectedAddress, newAddress);

	}

}
