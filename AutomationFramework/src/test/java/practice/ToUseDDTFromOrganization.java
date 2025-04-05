package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ToUseDDTFromOrganization {

	public static void main(String[] args) throws IOException   {
		// TODO Auto-generated method stub

		//Create FileInputStream
		FileInputStream  pfis = new FileInputStream(".\\src\\test\\resources\\CommonData");
		Properties props=  new Properties();
		props.load(pfis);
		String BROWSER = props.getProperty("browser");
		String URL = props.getProperty("url");
		String USERNAME = props.getProperty("username");
		String PASSWORD = props.getProperty("password");
		
		//Read the data from excel file
		
		FileInputStream  efis = new FileInputStream(".\\src\\test\\resources\\TestData001.xlsx");
		Workbook wb = WorkbookFactory.create(efis);
		String Organame = wb.getSheet("Contacts").getRow(4).getCell(4).toString();
		
		WebDriver driver = null;
		if(BROWSER.equals("chrome")) {
			driver= new ChromeDriver();
			
		}else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}else if(BROWSER.equals("fIREFOX")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(URL);
	    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("submitButton")).click();
	    
	    
	    driver.findElement(By.linkText("Organizations")).click();
	    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    
	    driver.findElement(By.name("Organization name")).sendKeys(Organame);
	    
	    
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		  String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		  if(name.contains(Organame)) {
			  System.out.println(name+"......passed");
		  }else {
			  System.out.println(name+"........Failed");
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
