package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductInfo {

	//declaration
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement ProdHeaderTxt;
	
	//Initialization
	public CreateNewProductInfo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getProdHeaderTxt() {
		return ProdHeaderTxt;
	}
	
	//Business Libraries
	/**
	 * This method returns Product information header text
	 * @return
	 */
	public String gatProdInfoHeaderText()
	{
		return ProdHeaderTxt.getText();
	}
	
	
}
