package crudWithBDD;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;//type resta(alt+spcae) and import this statement also make this as static

public class GetAllProjectsTest {
	
	@Test
	public void GetAllProjects() {
		
		
		
		when()
			.get("http://localhost:8084/projects")
		.then()
			.assertThat().statusCode(200)
			.and()
			.assertThat().contentType("application/json")
			.log().all();
		
		
	}

	
}
