package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {

	//Declaration
	@FindBy(xpath="//img[@title='Create Vendor...']")
	private WebElement CreateVendorImg;
	
	//Initialization
	public VendorsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getCreateVendorImg() {
		return CreateVendorImg;
	}
	
	//Business library
	public void ClickOnCreateVendorImage()
	{
		CreateVendorImg.click();
	}
}
