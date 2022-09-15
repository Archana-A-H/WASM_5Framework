package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
//declaration
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement CreateNewContactImg;
	
	//Initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getCreateNewContactImg() {
		return CreateNewContactImg;
	}
	
	//Business libraries
	public void clickOnCreateNewContactImg()
	{
		CreateNewContactImg.click();
	}
	
}
