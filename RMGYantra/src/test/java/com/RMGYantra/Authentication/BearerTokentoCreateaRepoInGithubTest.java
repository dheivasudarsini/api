package com.RMGYantra.Authentication;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class BearerTokentoCreateaRepoInGithubTest {
	
	@Test
	public void BearerAuthToken() {
		
		JSONObject jobj = new JSONObject();
		
		jobj.put("name", "Bearer tken auth repo");
		jobj.put("description", "tst repo");
		
           given()
            .body(jobj)
            .contentType(ContentType.JSON)
           	.auth().oauth2("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")
           .when()
           	.post("https://api.github.com/user/repos")
           	.then()
           		.assertThat().statusCode(201)
           		.time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS)
           		.log().all();
	}

}
