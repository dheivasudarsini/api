package crudWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectTest {
	
	@Test
	public void CreateProject(){
		
       JSONObject jobj = new JSONObject();
       

		jobj.put("createdBy", "sudha");
		jobj.put("projectName", "Yantra");
		jobj.put("status", "ongoing");
		jobj.put("teamSize", 20);
		
		given()
			.body(jobj)
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
