package crudWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteProjectsTest {
	
	@Test
	public void DeleteProjects()
	{
		when()
			.delete("http://localhost:8084/projects/TY_PROJ_605")
		.then()
			.assertThat().statusCode(200)
			.and()
			.assertThat().contentType("application/json")
			.and()
			.log().all();
			
			
	}

}
