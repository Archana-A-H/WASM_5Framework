package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vitiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	//declaration
	
	@FindBy(linkText="Leads")
	private WebElement LeadsLnk;
	
	@FindBy(linkText="Organizations")
	private WebElement OrgLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement ConLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement OppLnk;
	
	@FindBy(linkText="Products")
	private WebElement ProLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminImg;
	
	@FindBy(linkText="Sign Out")	
	private WebElement SignOutLnk;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement MoreList;
	
	@FindBy(name="Vendors")
	private WebElement VendorsLnk;
	
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization

	public WebElement getLeadsLnk() {
		return LeadsLnk;
	}

	public WebElement getOrgLnk() {
		return OrgLnk;
	}

	public WebElement getConLnk() {
		return ConLnk;
	}

	public WebElement getOppLnk() {
		return OppLnk;
	}

	public WebElement getProLnk() {
		return ProLnk;
	}

	public WebElement getAdminImg() {
		return AdminImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	
	public WebElement getMoreList() {
		return MoreList;
	}

	public WebElement getVendorsLnk() {
		return VendorsLnk;
	}
	
	//Business libraries
	/**
	 * This method signs out of the application
	 * @param driver
	 */
	public void signOutApp(WebDriver driver)
	{
		mouseHover(driver,AdminImg);
		SignOutLnk.click();
	}
	/**
	 * This method clicks on organizations link
	 * @param driver
	 */
	public void clickOnOrg()
	{
		OrgLnk.click();
	}
    /**
     * This method clicks on leads link
     * @param driver
     */
	public void clickOnContacts()
	{
		ConLnk.click();
	}
	
	public void ClickOnVendors(WebDriver driver)
	{
		mouseHover(driver,MoreList);
		VendorsLnk.click();
	}
    
	public void ClickOnProducts()
	{
		ProLnk.click();
	}
	
	
}
