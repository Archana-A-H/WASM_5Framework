package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
//declaration
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement CreateNewOrgImg;
	
	//Initialization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
    //Utilization
	public WebElement getCreateNewOrgImg() {
		return CreateNewOrgImg;
	}
	
	//Business libraries
	public void ClickOnCreateNewOrgImg()
	{
		CreateNewOrgImg.click();
	}
	
}
