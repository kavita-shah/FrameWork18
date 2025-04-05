package practice;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ObjectRepository.CreateOrganizationPage1;
import ObjectRepository.HomePage;
import ObjectRepository.Loginpage;
import ObjectRepository.OrganizationInfoPage;
import ObjectRepository.OrganizationPage;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import genericUtility.excelFielUtility;

public class DemoScriptWithGenericUtilityAndPOM {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
        PropertyFileUtility putil = new PropertyFileUtility();
	    excelFielUtility   eutil = new excelFielUtility();
		WebDriverUtility wutil = new WebDriverUtility();

		
				//Read the data from propertyFile
		String URL = putil.toReadDataFromPropertyFile("url");
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");
		

		
		//Read the data from excel file
		String Organization = eutil.toReadDataFromExcelFile("Organization", 1, 2);
				
				//Step 1: Launch the browser
			WebDriver driver = null;
			if(BROWSER.equals("chrome")) {
				driver = new ChromeDriver();
			}else if (BROWSER.equals("edge")) {
				driver = new EdgeDriver();
			}else if(BROWSER.equals("firefox")) {
				driver = new FirefoxDriver();
			}
			
			
			wutil.toMaximize(driver);
			wutil.toWaitElement(driver);
			
			//Step 2: Login with valid credentials
			driver.get(URL);
		    Loginpage lp = new Loginpage(driver);   
			lp.getUsernameTextField().sendKeys(USERNAME);
			lp.getPasswordTextField().sendKeys(PASSWORD);
			lp.getLoginButton().click();
			
			//Step 3: Click on organization link
			HomePage hp = new HomePage(driver);
			hp.getOrganizationsLink().click();
			
			//Step 4: Click on organization look up image
			OrganizationPage op= new OrganizationPage(driver);
	        op.getOrganizationLokkupImage().click();
	        
	        
	        //Give rendom number
	        Random r = new Random();
	   	    int random = r.nextInt(1000);
	        
	        //Step 5: Fill the details
	        CreateOrganizationPage1 cop1 = new CreateOrganizationPage1(driver);
	        cop1.getOrganizationNameTextfield().sendKeys(Organization +random);
	        
	        //Step 6 : Save and verify
	        cop1.getSaveButton().click();
	        OrganizationInfoPage info = new OrganizationInfoPage(driver);
	        String name = info.getOrganizationInfopage().getText();
	        if(name.contains(Organization)) {
	        	System.out.println(name+"...............Passed");
	        }else {
	        	System.out.println(name+"...............Failed");
	        }
	        
	        
	        //Step 7 : Logout
	        wutil.toMouseHover(driver, hp.getLogout());
	        hp.getSignoutLink().click();
	        
	        //Step 8: Close
	        driver.quit();
	        
	        
	        
	        
	        

	}

}
