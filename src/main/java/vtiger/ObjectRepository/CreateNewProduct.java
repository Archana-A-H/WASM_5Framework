package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vitiger.GenericUtilities.WebDriverUtility;

public class CreateNewProduct extends WebDriverUtility{
	
	//declaration
	@FindBy(name="productname")
	private WebElement ProdNameEdt;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement SelectVendorImg;
	
	@FindBy(id="search_txt")
	private WebElement SearchEdt;
	
	@FindBy(name="search")
    private WebElement SearchBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	//Initialization
	public CreateNewProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getProdNameEdt() {
		return ProdNameEdt;
	}

	public WebElement getSelectVendorImg() {
		return SelectVendorImg;
	}

	public WebElement getSearchEdt() {
		return SearchEdt;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Business Libraries
	/**
	 * This method creates new Product with name 
	 * @param ProdName
	 */
	public void CreateProduct(String ProdName)
	{
		ProdNameEdt.sendKeys(ProdName);
		SaveBtn.click();
	}
	
	/**
	 * This method creates product with name and vendor
	 * @param driver
	 * @param ProdName
	 * @param VendorName
	 * @throws InterruptedException 
	 */
	public void CreateProdVendor(WebDriver driver,String ProdName,String VendorName) throws InterruptedException
	{
		ProdNameEdt.sendKeys(ProdName);
		SelectVendorImg.click();
		switchToWin(driver,"Vendors");
		SearchEdt.sendKeys(VendorName);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+VendorName+"']"));
		switchToWin(driver,"Products");
		SaveBtn.click();
	}
	
}
