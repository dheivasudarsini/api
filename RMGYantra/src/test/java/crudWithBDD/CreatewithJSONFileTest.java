package crudWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreatewithJSONFileTest {
	
	@Test
	public void createwithExternal() {
 		
	         File file = new File("./jsonfile.json");
	         
	         given()
	         	.body(file)
	         	.contentType(ContentType.JSON)
	         .when()
	         	.post("http://localhost:8084/addProject")
	         .then()
	         	.assertThat().statusCode(201)
	         	.and()
	         	.assertThat().contentType("application/json")
	         	.and()
	         	.log().all();
		
		
	}

}
