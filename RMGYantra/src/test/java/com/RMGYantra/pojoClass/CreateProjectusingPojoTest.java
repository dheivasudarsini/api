	package com.RMGYantra.pojoClass;

import org.testng.annotations.Test;

import com.RMGYantra.GenericLib.Pojoclass;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectusingPojoTest  {
	
	@Test
	public void CreateProject() {
		
		
		
		
		Pojoclass pojoObj = new Pojoclass("Lavendar","Audi", "completed", 10);
		
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
