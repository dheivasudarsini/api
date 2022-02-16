package com.RMGYantra.pojoClass;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RMGYantra.GenericLib.Pojoclass;

import io.restassured.http.ContentType;

public class CreateMultipleProjectsusingPojoClassTest {

	
	@DataProvider
	public Object[][] provideData() {
		
		Object[][] objArray = new Object[4][4];
		
		objArray[0][0]="javid";
	    objArray[0][1]="ssss";
	    objArray[0][2]="completed";
	    objArray[0][3]= 10;
	    
	    objArray[1][0]="noah";
	    objArray[1][1]= "mi";
	    objArray[1][2]="ongoing";
	    objArray[1][3]= 22;
	    						
	    objArray[2][0]="sudha";
	    objArray[2][1]="rcb";
	    objArray[2][2]="completed";
	    objArray[2][3]=33;
	    														
	    objArray[3][0]="gds";
	    objArray[3][1]="csk";
        objArray[3][2]="ongoing";
	    objArray[3][3]=44;
	    
	    return objArray;
	}
	
	@Test(dataProvider = "provideData")
	public void createProject(String createdBy, String projectName, String status, int teamSize) {
		
		
		Pojoclass pojoObj = new Pojoclass(createdBy, projectName, status, teamSize);
		
		given()
		     .contentType(ContentType.JSON)
		     .body(pojoObj)
		 .when()
		     .post("http://localhost:8084/addProject")
		  .then()
		      .assertThat().statusCode(201)
		      .and()
		      .assertThat().contentType(ContentType.JSON)
		      .log().all();
		 

	}

	
	
	
}
