package responseValidation;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationTest {
	
	@Test
	public void StaticValidation() {
		
        //to store the data we are doing like this that is we will store it in "response"
	    String expectedName = "Apple";
		
	    Response response = when()
			.get("http://localhost:8084/projects");
	    response.then().assertThat().statusCode(200)
	    .log().all();
	    
	    String actualName = response.jsonPath().get("[1].projectName");
	    System.out.println(actualName);
	    Assert.assertEquals(actualName, expectedName);
	}
	
	  

}
