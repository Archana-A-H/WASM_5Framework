package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationInfo {
	//declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHeaderTxt;
	
	//Initialization
	public CreateOrganizationInfo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
   
	//Utilization
	public WebElement getOrgHeaderTxt() {
		return OrgHeaderTxt;
	}
   
	//Business Library
	public String getOrgHeader()
	{
		String OrgHeader = OrgHeaderTxt.getText();
		return OrgHeader;
	}
	
}
