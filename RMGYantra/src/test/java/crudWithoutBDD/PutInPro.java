package crudWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PutInPro {

	@Test
	public void put() {
		
		
		 JSONObject js = new JSONObject();
		 js.put("createdBy", "lusu");
		  
		 RequestSpecification rs = RestAssured.given();
		  
		  rs.body(js);
		  rs.contentType(ContentType.JSON);
		  
		  Response resp = rs.put("http://localhost:8084/projects/TY_PROJ_602");
		  ValidatableResponse vr = resp.then();
		  
		  vr.assertThat().statusCode(200);
		  vr.log().all();
		  
	}
	
	
}
