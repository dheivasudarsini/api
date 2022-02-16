package crudWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {
	@Test
	public void createProject() {
		
		JSONObject jobj = new JSONObject();
		
		jobj.put("createdBy", "dheiva");
		jobj.put("projectName", "RmgYantra");
		jobj.put("status", "created");
		jobj.put("teamSize", 10);
		
		 RequestSpecification reqSpec = RestAssured.given();
		 reqSpec.contentType(ContentType.JSON);
		 reqSpec.body(jobj);
		 
		 
		 Response response = reqSpec.post("http://localhost:8084/addProject");
		 
		  ValidatableResponse validateres = response.then();
		  validateres.assertThat().statusCode(201);
		  validateres.assertThat().contentType("application/json");
		  validateres.log().all();
		 
		 
		 
		
	}

}

