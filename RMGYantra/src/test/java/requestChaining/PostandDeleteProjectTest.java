package requestChaining;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.RMGYantra.GenericLib.Pojoclass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostandDeleteProjectTest {
	
	@Test
	public void PostandDelete() {
		
         Pojoclass pojoObj = new Pojoclass("Orange","Mercedes","testing",23);		
		 Response response = given()
			.contentType(ContentType.JSON)
			.body(pojoObj)
		.when()
			.post("http://localhost:8084/addProject");
		
		 String responseProId = response.jsonPath().get("projectId");
		 System.out.println(responseProId);
		
		 
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