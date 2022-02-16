package crudWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteProjectTest {
	
	@Test
	public void DeleteProject() {
		
		Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_602");
		
		ValidatableResponse validateRes = response.then();
		validateRes.assertThat().statusCode(204);
		validateRes.contentType("application/json");
		validateRes.log().all();
		 
		 
		
	}

}
