package crudWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DelProj {
	
	@Test
	public void del() {
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_006");
		
		ValidatableResponse  vr = resp.then();
		
		vr.assertThat().statusCode(204);
		vr.assertThat().contentType("application/json");
		vr.log().all();
	}

}
