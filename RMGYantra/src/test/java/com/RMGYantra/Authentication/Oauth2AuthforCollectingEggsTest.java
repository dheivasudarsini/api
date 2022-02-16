package com.RMGYantra.Authentication;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Oauth2AuthforCollectingEggsTest{
	
	@Test
	public void CollectEggs() {
		
		Response response = given()
			.formParam("client_id", "My First Application")
			.formParam("client_secret", "a7d71967e6e2d2fb6dcc8a3613333063")
			.formParam("grant_type", "client_credentials")
			.formParam("redirect_uri", "https://example.com")
			
			.when()
				.post("http://coop.apps.symfonycasts.com/token");
		
		   
			String accessToken = response.jsonPath().get("access_token");
					
				given()
					.auth().oauth2(accessToken)
					.pathParam("USER_ID", 2817)
					
				.when()
					.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/toiletseat-down")

				.then()
						.assertThat().time(Matchers.lessThan(5000l),TimeUnit.SECONDS)
						.log().all();
			
       
	}

}
