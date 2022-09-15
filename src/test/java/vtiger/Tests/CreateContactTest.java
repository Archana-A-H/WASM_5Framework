package vtiger.Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import vitiger.GenericUtilities.ExcelFileUtility;
import vitiger.GenericUtilities.PropertyFileUtility;
import vitiger.GenericUtilities.WebDriverUtility;

public class CreateContactTest {

	public static void main(String[] args) throws IOException {
		WebDriver driver;
		
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		//Step 2:read all neccesary data
		String Browser = pUtil.readFromPropertyFile("browser");
		String Url = pUtil.readFromPropertyFile("url");
		String Username = pUtil.readFromPropertyFile("username");
		String Password = pUtil.readFromPropertyFile("password");
		
		String LastName = eUtil.readFromExcelSheet("Contacts", 1, 2);
		
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
       
       //Login to application
       driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 4:Navigate to Contacts Link
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 5:Navigate to create Contacts image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//Step 6:Create Contact With mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		
		//Step 7:Save and validate Contact
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]'][1]")).click();
		String conHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(conHeader);
		if(conHeader.contains(LastName))
		{
			System.out.println("PASS");
			System.out.println("CONTACT CREATED");
		}
		else
		{
			System.out.println("FAIL");
			System.out.println("CONTACT NOT CREATED");
		}
		
		//Step 8:Log out
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    wUtil.mouseHover(driver, ele);
	    driver.findElement(By.linkText("Sign Out")).click();
	    
	    
	}

}
