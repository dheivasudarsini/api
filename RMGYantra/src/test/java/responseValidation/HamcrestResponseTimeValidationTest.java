package responseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.RMGYantra.GenericLib.Pojoclass;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class HamcrestResponseTimeValidationTest {
	
	@Test
	public void hamcrestResponseTimeValidation(){
		
		
		when()
			.get("http://localhost:8084/projects")
		.then()
			.assertThat().time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS)
		//type time, in bracket type match and in the templates choose 
		//Matchers as class from hamcrest and then select the less than option
			.assertThat().body("[20].projectName", Matchers.equalTo("Yantra"))
			.log().all();
		
		
		/*Pojoclass pojoobj = new Pojoclass("Rahane", "DD","completed",30);
		given()
		    .body(pojoobj)
		    .contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/projects/addProject")
		.then()
			.assertThat().body("projectName", Matchers.equalTo("DD"))
			.log().all();*/
			
		
	}

}
