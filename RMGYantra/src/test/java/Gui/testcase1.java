package Gui;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testcase1 {
	
	@Test
	public void tc1() {
		String act = null;
		String exp = "api";
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
	    	if (a.getText().equals(e))
	    	{
	    		act =a.getText();
	    		break;
	    		
	    	}
	    }
		
		System.out.println(act);
		dr.close();
		
		
	}

}
