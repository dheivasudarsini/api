package responseValidation;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidationTest {
 
	
	@Test
	
	public void dynamicValidation() {
    	 	
		   String expectedProjectName ="Project2";
	       Response response = when()
	    		  .get("http://localhost:8084/projects");
	       response.then().log().all();
	       
	       //boolean flag = false;
	       String actualProjectName = null;
	       List<String> responseProjectNames = response.jsonPath().get("projectName");
	       
	       for(String singleProjectName : responseProjectNames) {
	    	   
	    	   if(singleProjectName.equals(expectedProjectName)) {
	    		   
	    		   actualProjectName = singleProjectName;
	    		 // flag = true;
	    		   break;
	    	   }
	    	   
	       }  
	       System.out.println(actualProjectName);
    	   //Assert.assertEquals(flag, true);
    	   Assert.assertEquals(actualProjectName, expectedProjectName);
	}
}
