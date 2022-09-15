package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendorInfo {
	
	//Declaration
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement vendorHeaderTxt;
	
	//Initialization
	public CreateVendorInfo(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getVendorHeaderTxt() {
		return vendorHeaderTxt;
	}
	
	//Business Library
	public String getVendorInfoText()
	{
		return vendorHeaderTxt.getText();
	}

}
