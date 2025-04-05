package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToCreateContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Step no : Launch browser
 WebDriver driver = new ChromeDriver();
 driver.manage().window().maximize();
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
 
 //Step 2: 	Login to application with credentials
 driver.get("http://localhost:8888/");
 driver.findElement(By.name("user_name")).sendKeys("admin");
 driver.findElement(By.name("user_password")).sendKeys("password");
 driver.findElement(By.id("submitButton")).click();
 
 
 //Step 3: Navigate to contact link
 
 driver.findElement(By.linkText("Contacts")).click();
 
 //Step 4 : Click on create contact look up image
 driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
 
 //Step 5: create contact with mandatory fields
 driver.findElement(By.name("lastname")).sendKeys("kavita shah");
 
 //Step 6: Save and verify
 
 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
  String lastname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
  if(lastname.contains("kavita shah ")) {
	  System.out.println("kavita shah"+"......passed");
  }else {
	  System.out.println("kavita shah"+"........Failed");
  }
  
  
  //Step 7: click on logout
  WebElement SignoutAction = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
  Actions action = new Actions(driver);
  action.moveToElement(SignoutAction).perform();
  
  driver.findElement(By.linkText("Sign Out")).click();
  
  
 //step :8 Close Browser
  driver.quit();
 
 
 
 
 
 
 
	
	}

}
