package com.RMGYantra.Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerTokenAuthtoListAllReposTest {
	
	
	@Test
	public void BearerTokenAuth() {
		
         given()
         	.auth().oauth2("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")
         .when()
         	.get("https://api.github.com/user/repos")
         .then()
         	.assertThat().statusCode(200)
         	.log().all();
	}

}
