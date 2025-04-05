package contactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepository.ContactInfoPage;
import ObjectRepository.CreateContactPage;

import ObjectRepository.HomePage;

import ObjectRepository.contactPage;
import genericUtility.BascClass;
import genericUtility.WebDriverUtility;
import genericUtility.excelFielUtility;

public class ToCreateContactWithOrgTest extends BascClass {
	
	@Test (groups="smoke")
	public void toCreateContactWithOrg_002() throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();
		contactPage cp= new contactPage(driver);
		cp.getCreateLookupimagelink().click();
		
		//To pass the data in lastname 
	   excelFielUtility eutil = new excelFielUtility();
	   String LASTNAME = eutil.toReadDataFromExcelFile("Contacts", 1, 2);
	   CreateContactPage ccp = new CreateContactPage(driver);
	   ccp.getLastnameTextfield().sendKeys(LASTNAME);
	  
	   //To click on org look up image
	   ccp.getPlusIcon().click();
	   WebDriverUtility wutil = new  WebDriverUtility();
	   
	   //To switch driver control to child window
	   wutil.toSwitchWindow(driver, "Accounts");
	   
	   //Click on abc.com
	   
	   driver.findElement(By.xpath("//a[text()='ABC.com']")).click();
	   
	   //To switch back driver control to driver
	   wutil.toSwitchWindow(driver, "Contacts");
	   
	   //Save and verify
	   ccp.getSaveButton().click();
	   ContactInfoPage cip = new ContactInfoPage(driver);
	  String name = cip.getContactInfo().getText();
	  Assert.assertTrue(name.contains(LASTNAME));
//	  if(name.contains(LASTNAME)) {
//		  System.out.println(name+"...............Passed");
//	  }else {
//		  System.out.println(name+"...............Faield");
//	  }
//	    
	
	}

}
