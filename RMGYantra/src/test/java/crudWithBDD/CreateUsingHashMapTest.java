
package crudWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Random;

public class CreateUsingHashMapTest {
    
	@Test
	public void CreateusingHM() {
	    
		
		Random ran = new Random();
		int ranNumber = ran.nextInt(2000);
		HashMap hmap = new HashMap();
		hmap.put("createdBy", "suhasini");
		hmap.put("projectName", "vela kedachuruchu"+ ranNumber);
		hmap.put("status", "on process");
		hmap.put("teamSize", 30);
		
		given()
			.body(hmap)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat()
			.statusCode(201)
			.and()
			.assertThat().contentType("application/json")
		    .and()
		    .log().all();
		
	}
}
