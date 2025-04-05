package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import genericUtility.excelFielUtility;

public class demoScriptWithDDTandGU {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		PropertyFileUtility putil = new PropertyFileUtility();
		excelFielUtility eutil = new excelFielUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		
		// Read data from propertyFile 
		String URL = putil.toReadDataFromPropertyFile("url");
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");
		
		//Read the data from excel file
		
		String LASTNAME = eutil.toReadDataFromExcelFile("Contacts", 1, 2);
		
		//Step 1: Launch the Browser
		WebDriver driver = null;
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
			
		}
		else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
		wutil.toMaximize(driver);  // maximize
		wutil.toWaitElement(driver);  // implicitly wait
		
		
		// Step 2 :  login with valid credentials
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3: Navigate to contact page 
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 4: click on add contact
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//Step 5: provide detail
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		//Step 6: clcik on save button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        if (name.contains(LASTNAME) ) {
        	System.out.println(name+"..............passed");
        }else {System.out.println(name+"...........Failed");
	}
        
      //  Step 7 : clcik on logout
        WebElement Signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        wutil.toMouseHover(driver, Signout);
        driver.findElement(By.linkText("Sign Out")).click();
        
        driver.quit();
        
        
	}
}
