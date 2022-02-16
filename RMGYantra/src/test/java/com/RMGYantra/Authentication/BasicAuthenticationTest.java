package com.RMGYantra.Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class BasicAuthenticationTest {

	@Test
	public void BasicAuthentication() {
		
		given()
			.auth().basic("rmgyantra", "rmgy@9999")
		.when()
			.get("http://localhost:8084/login")
		.then()
			.assertThat().statusCode(202)
			.assertThat().contentType(ContentType.JSON)
			.assertThat().log().all();
		
		

	}
}
