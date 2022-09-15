package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	//Declaration
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement CreateProdImg;
	
	//Initialization
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getCreateProdImg() {
		return CreateProdImg;
	}
	
	//Business Library
	/**
	 * This method clicks on create new product image
	 */
	public void ClickOnCreateProdImg()
	{
		CreateProdImg.click();
	}
	
}
