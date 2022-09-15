package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vitiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganization extends WebDriverUtility{
	//declaration
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement IndDropDown;
	
	@FindBy(xpath="//select[@ name='accounttype']")
	private WebElement TyDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	
	//Initialization
	public CreateNewOrganization (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndDropDown() {
		return IndDropDown;
	}

	public WebElement getTypeDropDown() {
		return TyDropDown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	//Business Libraries
	/**
	 * This method creates new organization with name
	 * @param Orgname
	 */
	public void createNewOrg(String Orgname)
	{
		OrgNameEdt.sendKeys(Orgname);
		SaveBtn.click();
	}
	/**
	 * This method creates new organization with name and industry
	 * @param Orgname
	 * @param Indtype
	 */
	public void createNewOrg(String Orgname,String Indtype)
	{
		OrgNameEdt.sendKeys(Orgname);
		handleDropDown(IndDropDown,Indtype);
		//handleDropDown(TyDropDown,Type);
		SaveBtn.click();
	}
	/**
	 * This method creates new organization with name,industry and type
	 * @param Orgname
	 * @param Indtype
	 * @param Type
	 */
	public void createNewOrg(String Orgname,int index)
	{
		OrgNameEdt.sendKeys(Orgname);
		handleDropDown(TyDropDown,index);
		SaveBtn.click();
	}
	
	
}
