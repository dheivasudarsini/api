package parameters;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class PathParameterTest {
	
	@Test
	public void pathParameter() {
		
		given()
			.pathParam("ProjectId","TY_PROJ_607")
			.when()
				.get("http://localhost:8084/projects/{ProjectId}")
			.then()
				.assertThat().statusCode(200)
				.assertThat().time(Matchers.lessThan(3000l),TimeUnit.MILLISECONDS)
				.log().all();
	}

}
