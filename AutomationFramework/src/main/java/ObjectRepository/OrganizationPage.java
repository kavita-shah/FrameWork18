package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	//constructor
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement organizationlink;
     
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement organizationLokkupImage;

	public WebElement getOrganizationlink() {
		return organizationlink;
	}

	public WebElement getOrganizationLokkupImage() {
		return organizationLokkupImage;
	}
	
	
	
		

}
