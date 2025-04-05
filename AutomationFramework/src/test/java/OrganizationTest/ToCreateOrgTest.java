package OrganizationTest;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepository.CreateOrganizationPage1;
import ObjectRepository.HomePage;
import ObjectRepository.OrganizationInfoPage;
import ObjectRepository.OrganizationPage;
import genericUtility.BascClass;
import genericUtility.excelFielUtility;

public class ToCreateOrgTest extends BascClass {

	@Test(groups="Regression")
	public void toCreateOrg_003() throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();
		OrganizationPage orp = new OrganizationPage(driver);
		orp.getOrganizationLokkupImage().click();
		CreateOrganizationPage1 corp = new CreateOrganizationPage1(driver);
		excelFielUtility eutil = new excelFielUtility();
		String Organization = eutil.toReadDataFromExcelFile("Organization", 1,2);
		Random r = new Random();
		int random = r.nextInt(1000);
		corp.getOrganizationNameTextfield().sendKeys(Organization+random);
		corp.getSaveButton().click();
		OrganizationInfoPage orip = new OrganizationInfoPage(driver);
		String name = orip.getOrganizationInfopage().getText();
		Assert.assertTrue(name.contains(Organization));
//		if(name.contains(Organization)) {
//			System.out.println(name+"............Passed");
//		}else {
//			System.out.println(name+"............Failed");
//		}
		
	}
}
