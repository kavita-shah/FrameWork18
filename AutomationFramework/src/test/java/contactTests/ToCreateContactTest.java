package contactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepository.ContactInfoPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.HomePage;
import ObjectRepository.contactPage;
import genericUtility.BascClass;
import genericUtility.excelFielUtility;

@Listeners(genericUtility.ListenersImpementation.class)
public class ToCreateContactTest extends BascClass {
	@Test(groups = "smoke")

	public void toCreateContact_001() throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();
		contactPage cp = new contactPage(driver);
		cp.getCreateLookupimagelink().click();
		CreateContactPage ccp = new CreateContactPage(driver);
		excelFielUtility eutil = new excelFielUtility();
		String LASTNAME = eutil.toReadDataFromExcelFile("Contacts", 1, 2);
		ccp.getLastnameTextfield().sendKeys(LASTNAME);
		ccp.getSaveButton().click();
		// Fail
		Assert.fail();
		ContactInfoPage cip = new ContactInfoPage(driver);
		String name = cip.getContactInfo().getText();
		System.out.println("================");

		// we use assert isted of doing if else condition
		Assert.assertTrue(name.contains(LASTNAME));
//	  if(name.contains(LASTNAME)) {
//		  System.out.println(name+"...............Passed");
//	  }else {
//		  System.out.println(name+"...............Faield");
//	  }
//	    

	}

}
