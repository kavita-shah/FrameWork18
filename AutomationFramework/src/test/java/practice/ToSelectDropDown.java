package practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ToSelectDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Step :1 Launch browser
				WebDriver driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			 
			 driver.get("http://localhost:8888/");
			 
			 //Step 2:Login to application with valid credentials
			 driver.findElement(By.name("user_name")).sendKeys("admin");
			 driver.findElement(By.name("user_password")).sendKeys("password");
			 driver.findElement(By.id("submitButton")).click();
			 
			 //Step 3:Navigate to organizations link
			 driver.findElement(By.linkText("Organizations")).click();
			 
			 //Step 4: Click on Organization look up image
			 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			 
			 //Step 5 Give random no
			 Random r =new Random();
			 int random = r.nextInt(1000);
			 
			 
			 
			 //Step 5:Create organization with mandatory fields
			 driver.findElement(By.name("accountname")).sendKeys("pqr.com"+random);
			 
			 //Step 6: Select "Chemicals " in industry dropDown
			 
			 WebElement industryName = driver.findElement(By.name("industry"));
			 Select dp =new Select(industryName);
			 dp.selectByValue("Chemicals");
			 
			 //Step 6: save and verify
			 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			 
			String CompanyName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(CompanyName.contains("pqr.com")) {
				System.out.println("Organization info verified"+"............passed");
			}else {
				System.out.println("Organization info verified"+"............faield");
				
			}
			
			//Step 7 : Logout from application
			 WebElement Logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions action = new Actions (driver);
			action.moveToElement(Logout).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			
			driver.quit();
			

			 


	}

}
