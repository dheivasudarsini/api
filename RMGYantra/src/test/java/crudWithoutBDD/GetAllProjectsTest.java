package crudWithoutBDD;

//import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllProjectsTest {
     @Test
     public void GetAllProjects() {
    	 
    	  
    	 
         Response response = RestAssured.get("http://localhost:8084/projects");
         
         System.out.println(response.asString());//to print the all projects
         System.out.println(response.prettyPrint());
         System.out.println(response.getContentType());
         System.out.println(response.getStatusCode());
         //System.out.println(response.getTime());
         
          //int actualStatus =response.getStatusCode();
          //Assert.assertEquals(actualStatus, 200);//testNG Assertion
          
          ValidatableResponse validateResp = response.then();
          validateResp.assertThat().statusCode(200);
          validateResp.assertThat().contentType("application/json");
          validateResp.log().all();
          
     }

}


