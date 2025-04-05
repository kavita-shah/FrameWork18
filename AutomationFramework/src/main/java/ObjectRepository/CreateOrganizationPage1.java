package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage1 {
	
	//Constructor
	
	public CreateOrganizationPage1 (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="accountname")
	private WebElement organizationNameTextfield;
	
	@FindBy(name="industry")
	private WebElement industryNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	@FindBy(name="accounttype")
	private WebElement typeTextField;

	public WebElement getOrganizationNameTextfield() {
		return organizationNameTextfield;
	}

	public WebElement getIndustryNameTextField() {
		return industryNameTextField;
	}
	
	
	
	public WebElement getSaveButton() {
		return savebutton;
		
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

	public WebElement getTypeTextField() {
		return typeTextField;
	}
	
}
