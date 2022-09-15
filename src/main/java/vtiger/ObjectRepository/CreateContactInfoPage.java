package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactInfoPage {
	//Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ConHeaderTxt;
	
	//Initialization
	public CreateContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getConHeaderTxt() {
		return ConHeaderTxt;
	}
	
	//Business libraries
	public String getContactHeader()
	{
		String conHeader = ConHeaderTxt.getText();
		return conHeader;
	}

	
}
