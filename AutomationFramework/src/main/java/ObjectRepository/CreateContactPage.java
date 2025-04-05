package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	
	//Constructor
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="lastname")
	private WebElement lastnameTextfield;
	
	@FindBy(name="account_name")
	private WebElement OrganizationNameTextField;
	
	
	@FindBy(xpath="//input[@name=\"account_id\"]/../..//img[@alt='Select']")
	private WebElement plusIcon;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	
	public WebElement getLastnameTextfield() {
		return lastnameTextfield;
	}

	public WebElement getOrganizationNameTextField() {
		return OrganizationNameTextField;
	}

	public WebElement getPlusIcon() {
		return plusIcon;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	
	
	
	
}
