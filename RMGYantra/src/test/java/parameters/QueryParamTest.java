package parameters;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class QueryParamTest {

	@Test
	public void QueryParam() {
		
		given()
			.queryParam("status", "pending")
		.when()
			.get("https://petstore.swagger.io/v2/pet/findByStatus")
		.then()
			.assertThat().time(Matchers.lessThan(3l),TimeUnit.SECONDS)
			.assertThat().statusCode(200)
			.assertThat().contentType(ContentType.JSON)
			.log().all();
			
			
	}
}
