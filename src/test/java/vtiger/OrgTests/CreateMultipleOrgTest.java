package vtiger.OrgTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vitiger.GenericUtilities.ExcelFileUtility;
import vitiger.GenericUtilities.JavaUtility;
import vitiger.GenericUtilities.PropertyFileUtility;
import vitiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.CreateNewOrganization;
import vtiger.ObjectRepository.CreateOrganizationInfo;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateMultipleOrgTest {
	//create objects of required utilities
	 JavaUtility jUtil=new JavaUtility();
	 PropertyFileUtility pUtil=new PropertyFileUtility();
	 ExcelFileUtility eUtil=new ExcelFileUtility();
	 WebDriverUtility wUtil=new WebDriverUtility();
	 
	 WebDriver driver;

	@Test(dataProvider="Orgdata")
	public void createMultiOrgTest(String OrgName,String IndType) throws IOException 
    {
		//Read all necessary data
		String Browser = pUtil.readFromPropertyFile("browser");
		String Url = pUtil.readFromPropertyFile("url");
		String UserName = pUtil.readFromPropertyFile("username");
		String Password = pUtil.readFromPropertyFile("password");
		
		//Launch the browser
		 if(Browser.equalsIgnoreCase("chrome"))
		 {
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			 System.out.println("CHROME BROWSER LAUNCHED");
		 }
		 else if(Browser.equalsIgnoreCase("firefox"))
		 {
			 WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
			 System.out.println("FIREFOX BROWSER LAUNCHED");
		 }
		 else
		 {
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			 System.out.println("DEFAULT CHROME BROWSER LAUNCHED");
		 }
          wUtil.maximizeWindow(driver);
          wUtil.waitForElementsToLoadInDom(driver, 20);
          driver.get(Url);
          
          //Login to app
           LoginPage lp=new LoginPage(driver);
           lp.loginToApp(UserName, Password);
           
           //Navigate to organization link
            HomePage hp=new HomePage(driver);
            hp.clickOnOrg();
            
           //Click on create organization image
            OrganizationsPage op=new OrganizationsPage(driver);
            op.ClickOnCreateNewOrgImg();
            
           //Create new organization with industry type
            CreateNewOrganization cno=new CreateNewOrganization(driver);
            cno.createNewOrg(OrgName+jUtil.getRandomNumber(), IndType);
            
            //validate
             CreateOrganizationInfo coi=new CreateOrganizationInfo(driver);
             String oHeader = coi.getOrgHeader();
             if(oHeader.contains(OrgName))
             {
      			System.out.println("ORGANIZATION CREATED SUCCESFULLY");
      			System.out.println(oHeader);
             }
             else
             {
            	 System.out.println("ORGANIZATION NOT CREATED");
             }
             
          //Sign out
             hp.signOutApp(driver);
             driver.close();
             
	}
	@DataProvider(name="Orgdata")
    public Object[][] getData() throws EncryptedDocumentException, IOException
    {
   	 return eUtil.readMultiDataFromExcel("MultipleOrg");
    }

}
