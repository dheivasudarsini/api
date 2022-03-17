package endToEndScenario;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.RMGYantra.GenericLib.Pojoclass;
import com.mysql.cj.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EndToEndScenarioTest {
	
	@Test
	public void EndToEndSce() throws SQLException {
		
		String expectedProjectName = null;
		String DbProjectName = null;
		 //create an object for pojo class
         Pojoclass pojoo =new Pojoclass("Blue","RCB","completed",20);
        		 
         //capture the project name from the response of the server
            Response response = given()
         	 .body(pojoo)
         	 .contentType(ContentType.JSON)
           .when()
           	 .post("http://localhost:8084/addProject");
            
            //assertions validating the response
            String responseProjectName = response.jsonPath().get("ProjectName");
            
            response.then()
            	.assertThat().statusCode(201)
            	.contentType(ContentType.JSON)
            	.time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS)
            	.log()
            	.all();
            
            //JDBC:load and reg the driver
             Driver driver = new Driver();
             DriverManager.registerDriver(driver);
            
            //establish the connection
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
             
             //create a statement
             Statement statement = connection.createStatement();
             
             //
             ResultSet result = statement.executeQuery("select * from project");
             
             
             
             while (result.next())
             {
            	 
				if (result.getString("project_name").equals(expectedProjectName))
				
				{
					
					DbProjectName = result.getString("project_name");
					break;
					
					
					
					
				}
				
				
             
             }
             connection.close();
             
				
				Assert.assertEquals(responseProjectName, expectedProjectName);
				Assert.assertEquals(DbProjectName, expectedProjectName);
				
				
				System.out.println("*****Selenium********");
				String act = null;
				String exp = "RmgYantra";
				WebDriver dr = new ChromeDriver();
				
				dr.get("http://localhost:8084");
				dr.manage().window().maximize();
				dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		;		dr.findElement(By.id("usernmae")).sendKeys("rmgyantra");
				dr.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
				dr.findElement(By.xpath("//button[text()='Sign in']")).click();
				
				dr.findElement(By.xpath("//a[text()='Projects']")).click();
				
			    List<WebElement> e = dr.findElements(By.xpath("//table[@class='table table-striped table-hover']//td[2]"));
			    
			    for(WebElement a : e)
			    {
			    	if (a.getText().equals(exp))
			    	{
			    		act =a.getText();
			    		break;
			    		
			    	}
			    }
				
				System.out.println(act);
				dr.close();
				
           	
           	
           	
	}

}
