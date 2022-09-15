package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendor {

	//declaration
	@FindBy(name="vendorname")
	private WebElement VendorNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//Initialization
	public CreateNewVendor(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getVendorNameEdt() {
		return VendorNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Business library
	public void CreateVendor(String Vname)
	{
		VendorNameEdt.sendKeys(Vname);
		SaveBtn.click();
	}
	
}
