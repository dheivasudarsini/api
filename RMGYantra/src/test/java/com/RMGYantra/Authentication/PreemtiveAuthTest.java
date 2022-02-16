package com.RMGYantra.Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PreemtiveAuthTest {
	
	@Test
	public void PreemtiveAuth() {
		
		given()
			.auth().preemptive().basic("rmgyantra", "rmgy@9999" )
	   .when()
	   	.get("http://localhost:8084/login")
	   .then()
	   		.assertThat().contentType(ContentType.JSON)
	   		.assertThat().statusCode(202)
	   		.log().all();
	}

}
