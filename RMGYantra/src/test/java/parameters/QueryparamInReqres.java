package parameters;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class QueryparamInReqres {

	@Test
	public void Queryparam() {
		
		given()
		.queryParam("path", "2")
	.when()
		.get("https://reqres.in/api/users")
	.then()
		.assertThat().time(Matchers.lessThan(3l),TimeUnit.SECONDS)
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
		
	}
	
}
