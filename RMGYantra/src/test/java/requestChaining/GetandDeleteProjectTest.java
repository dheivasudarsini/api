package requestChaining;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetandDeleteProjectTest {
	

	@Test
	public void getanddeleteProject() {
		
		Response response = when()
			.get("http://localhost:8084/projects");
		 String responseProId = response.jsonPath().get("[0].projectId");
		 System.out.println(responseProId);
		 response.then()
		 		.assertThat().statusCode(200)
		 		.assertThat().contentType(ContentType.JSON)
		 		.log().all();
		 
		 given()
		 	.pathParam("projectId", responseProId)
		 .when()
		 	.delete("http://localhost:8084/projects/{projectId}")
		 .then()
		 	.assertThat().statusCode(204)
		 	.assertThat().time(Matchers.lessThan(3l), TimeUnit.SECONDS)
		 	.log().all();
	}

}
