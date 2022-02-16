package com.RMGYantra.Authentication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DigestiveAuthTest {
    
	@Test
	public void DigestiveAuth() {
	 
		given()
			.auth().digest("rmgyantra", "rmgy@9999")
		.when()
			.get("http://localhost:8084/login")
		.then()
			.assertThat().statusCode(202)
			.assertThat().contentType(ContentType.JSON)
			.log().all();
		
	}
}
