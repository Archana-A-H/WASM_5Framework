package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vitiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{
	//declaration
	
	@FindBy(name="lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath="//input[@name='account_id']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement ExistingOrgImg;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(id="search_txt")
	private WebElement SearchTxtEdt;
	
	@FindBy(name="search")
	private WebElement SearchBtn;
	

	//Initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Utilization

	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getExistingOrgImg() {
		return ExistingOrgImg;
	}
	
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public WebElement getSearchTxtEdt() {
		return SearchTxtEdt;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

		
	//Business Libraries
	
	/**
	 * This method creates new contact with name
	 * @param lastname
	 */
	public void createNewContact(String lastname)
	{
		LastNameEdt.sendKeys(lastname);
		SaveBtn.click();
	}
	
	/**
	 * This method creates new contact with existing organization name
	 * @param driver
	 * @param partialTitle
	 * @param Title
	 * @param Orgname
	 */
	public void ClickOnExistingOrgImg(WebDriver driver,String Orgname,String lastname)
	{
		LastNameEdt.sendKeys(lastname);
		
		ExistingOrgImg.click();
		switchToWin( driver, "Accounts");	
	
		SearchTxtEdt.sendKeys(Orgname);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+Orgname+"']"));
		switchToWin(driver,"Contacts");
		SaveBtn.click();
	}

}
