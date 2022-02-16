package crudWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProj {

	@Test
	public void create() {

		JSONObject	jobj = new JSONObject();
		jobj.put("created By", "Rajnikanth");
		jobj.put("projectName","Petta");
		jobj.put("status", "released");
		jobj.put("teamsize", 20);
		
		 RequestSpecification rs = RestAssured.given();
		rs.body(jobj);
		rs.contentType(ContentType.JSON);
		
		Response resp = rs.post("http://localhost:8084/addProject");
		
		ValidatableResponse vr = resp.then();
		vr.assertThat().statusCode(201);
		vr.assertThat().contentType("application/json");
		vr.log().all();
		
		
		
}
}