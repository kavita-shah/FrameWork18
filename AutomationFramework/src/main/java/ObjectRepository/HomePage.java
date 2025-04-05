package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//Constructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText="Organizations")
	private WebElement organizationsLink;
	
    @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
    private WebElement logout;
    
    @FindBy(linkText="Sign Out")
    private WebElement signoutLink;

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}
}
