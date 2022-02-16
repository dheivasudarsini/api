package crudWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAll {

	@Test
	public void getAll() {
	Response resp = RestAssured.get("http://localhost:8084/projects");
	//System.out.println(resp.statusCode());
	//System.out.println(resp.contentType());
	//System.out.println(resp.asString());
	System.out.println(resp.asPrettyString());
	
	ValidatableResponse  vr = resp.then();
	
	vr.assertThat().statusCode(200);
	vr.assertThat().contentType("application/json");
	vr.log().all();
	}
	
	
}
