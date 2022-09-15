package vtiger.Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vitiger.GenericUtilities.ExcelFileUtility;
import vitiger.GenericUtilities.JavaUtility;
import vitiger.GenericUtilities.PropertyFileUtility;
import vitiger.GenericUtilities.WebDriverUtility;

public class CreateContactwithOrganizationTest {

	public static void main(String[] args) throws IOException {
		WebDriver driver;
		      //Step 1:create object of all utilities
				JavaUtility jUtil=new JavaUtility();
				PropertyFileUtility pUtil=new PropertyFileUtility();
				ExcelFileUtility eUtil=new ExcelFileUtility();
				WebDriverUtility wUtil=new WebDriverUtility();
				
				//Step 2:read all neccesary data
				String Browser = pUtil.readFromPropertyFile("browser");
				String Url = pUtil.readFromPropertyFile("url");
				String Username = pUtil.readFromPropertyFile("username");
				String Password = pUtil.readFromPropertyFile("password");
				
				String Orgname=eUtil.readFromExcelSheet("Contacts", 1, 3)+jUtil.getRandomNumber();
				String Lastname = eUtil.readFromExcelSheet("Contacts", 1, 2);
				
				//Step 3:launch the browser
				if(Browser.equalsIgnoreCase("chrome"))
				{
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
					System.out.println("Chrome Browser Launched");
				}
				else if(Browser.equalsIgnoreCase("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
					System.out.println("Firefox Browser Launched");
				}
				else
				{
					System.out.println("Invalid browser");
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
					System.out.println("Chrome Browser Launched");
				}
				wUtil.maximizeWindow(driver);
		       wUtil.waitForElementsToLoadInDom(driver, 20);
		       driver.get(Url);
		       
		       //Step 4:Login to application
		       driver.findElement(By.name("user_name")).sendKeys(Username);
				driver.findElement(By.name("user_password")).sendKeys(Password);
				driver.findElement(By.id("submitButton")).click();
				
				//Step 4:Navigate to Organization Link 
				driver.findElement(By.linkText("Organizations")).click();
				
				//Step 5:create organization with mandatory fields and save
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				driver.findElement(By.name("accountname")).sendKeys(Orgname);
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
				String Orgheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				System.out.println(Orgheader);
				if(Orgheader.contains(Orgname))
				{
					System.out.println("PASS");
					System.out.println("ORGANIZATION CREATED");
				}
				else
				{
					System.out.println("FAIL");
					System.out.println("ORGANIZATION NOT CREATED");
				}
				//Step 5:Navigate to Contacts Link
				driver.findElement(By.linkText("Contacts")).click();
				
				//Step 6:create Contacts with mandatory fields and organization
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				driver.findElement(By.name("lastname")).sendKeys(Lastname);
				driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
				
				//switch control to child window
				  wUtil.switchToWin(driver, "Accounts");
				  driver.findElement(By.id("search_txt")).sendKeys(Orgname);
				  driver.findElement(By.name("search")).click();
				  driver.findElement(By.linkText(Orgname)).click();
				//switch control back to parent
				  wUtil.switchToWin(driver, "Contacts");
				  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				 String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				 System.out.println(contactHeader);
					if(contactHeader.contains(Lastname))
					{
						System.out.println("PASS");
						System.out.println("CONTACT CREATED");
					}
					else
					{
						System.out.println("FAIL");
						System.out.println("CONTACT NOT CREATED");
					}
					
				//Step 7:Logout
					wUtil.mouseHover(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
					driver.findElement(By.linkText("Sign Out")).click();
					

	}

}
