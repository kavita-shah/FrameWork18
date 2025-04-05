package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactPage {
	
	//Constructor
	public contactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
 
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createLookupimagelink;


	public WebElement getCreateLookupimagelink() {
		return createLookupimagelink;
	}
	
}
