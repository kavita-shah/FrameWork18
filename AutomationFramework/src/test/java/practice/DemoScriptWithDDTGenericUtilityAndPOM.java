package practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ObjectRepository.ContactInfoPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.HomePage;
import ObjectRepository.Loginpage;
import ObjectRepository.contactPage;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import genericUtility.excelFielUtility;

public class DemoScriptWithDDTGenericUtilityAndPOM {

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
		String LASTNAME = eutil.toReadDataFromExcelFile("Contacts", 1, 2);
		
		
		//Step 1: Launch the browser
		WebDriver driver = null;
	if(BROWSER.equals("chrome")) {
		driver = new ChromeDriver();
	}else if(BROWSER.equals("edge")) {
		driver = new EdgeDriver();
	}else if(BROWSER.equals("firefox")) {
		driver = new FirefoxDriver();
	}
	
	wutil.toMaximize(driver);
	wutil.toWaitElement(driver);
	
	//STEP 2: lOGIN TO APPLICATION WITH VALID Credentials
	
	driver.get(URL);
    Loginpage lp = new Loginpage(driver);   
	lp.getUsernameTextField().sendKeys(USERNAME);
	lp.getPasswordTextField().sendKeys(PASSWORD);
	lp.getLoginButton().click();
	
	//Step 3: Click on contact link
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();
		
		//Step 4: Click on create contact look up page
		contactPage cp = new contactPage(driver);
		cp.getCreateLookupimagelink().click();
		
		//Step 5: Fill in the details
		
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getLastnameTextfield().sendKeys(LASTNAME);
		
		//Step 6: save and verify
		
		ccp.getSaveButton().click();
		ContactInfoPage cip = new ContactInfoPage(driver);
		String name= cip.getContactInfo().getText();
		if(name.contains(LASTNAME)) {
			System.out.println(name+".........Passed");
		}else {
			System.out.println(name+"........Failed");
		}
		
		//step 7: logout
		wutil.toMouseHover(driver, hp.getLogout());
		hp.getSignoutLink().click();
		
		//step 8: close
		driver.quit();
		
 }

}
