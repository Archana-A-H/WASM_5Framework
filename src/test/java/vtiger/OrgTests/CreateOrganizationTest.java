package vtiger.OrgTests;

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

public class CreateOrganizationTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver;
		
		//Step 1:Create objects of all utilities
		
		JavaUtility jUtil=new JavaUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		//Step 2:Read necessary data
		
		String BROWSER = pUtil.readFromPropertyFile("browser");
		String URL = pUtil.readFromPropertyFile("url");
		String UN = pUtil.readFromPropertyFile("username");
		String PWD = pUtil.readFromPropertyFile("password");
		
		String ORGNAME = eUtil.readFromExcelSheet("Organization", 1, 2)+jUtil.getRandomNumber();
		
		//Step 3:Launch Browser
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("CHROME BROWSER LAUNCHED");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("FIREFOX BROWSER LAUNCHED");
		}
		else
		{
			System.out.println("INVALID BROWSER");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("DEFAULT CHROME DRIVER LAUNCHED");
		}
		wUtil.maximizeWindow(driver);
		wUtil.waitForElementsToLoadInDom(driver, 20);
		driver.get(URL);
		
		//Step 4:Login to App
		
		  driver.findElement(By.name("user_name")).sendKeys(UN);
		  driver.findElement(By.name("user_password")).sendKeys(PWD);
		  driver.findElement(By.id("submitButton")).click();
		  //wUtil.alertAccept(driver);
		
		//Step 5:Navigate to Organizations Link
		  
		  driver.findElement(By.linkText("Organizations")).click();
		  driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		  driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//Step 6:Save and validate
		  
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		  String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		  System.out.println(orgHeader);
		  if(orgHeader.contains(ORGNAME)) 
		  {
			System.out.println("PASS");
			System.out.println("ORGANIZATION CREATED");
		  }
		  else
		  {
			System.out.println("FAIL");
			System.out.println("ORGANIZATION NOT CREATED");
		  }
		
		//Step 7:Log Out
		  
		  wUtil.mouseHover(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))); 
		  Thread.sleep(1000);
		  driver.findElement(By.linkText("Sign Out")).click();  
		  
		
		
	}

}
