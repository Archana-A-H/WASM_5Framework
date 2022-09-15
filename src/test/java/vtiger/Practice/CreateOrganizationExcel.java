package vtiger.Practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateOrganizationExcel {

	public static void main(String[] args) throws IOException {
WebDriver driver;
		
		//Generate random number to avoid duplicate data
		Random r = new Random();
		int RANDOM = r.nextInt(1000);
		
		//Step 1: Read the necessary Data
		//-----Property File -> Common Data-----
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties pObj = new Properties();
		pObj.load(fisp);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		//--Excel Sheet Test Data--
		File file=new File(".\\src\\test\\resources\\testData.xlsx");
		FileInputStream fise=new FileInputStream(file);
	    Workbook wb= WorkbookFactory.create(fise);
		org.apache.poi.ss.usermodel.Sheet sh= wb.getSheet("Sheet1");
		org.apache.poi.ss.usermodel.Row row=sh.getRow(1);
		org.apache.poi.ss.usermodel.Cell c=row.getCell(2);
		String Orgname = c.getStringCellValue();
		
		//Step 2: launch the browser --- Run time Polymorphism
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			System.out.println("----- chrome browser launched successfully-----");
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) 
		{
			driver = new FirefoxDriver();
			System.out.println("-----firefox browser launched successfully----");
		}
		else
		{
			System.out.println("browser invalid");
			driver = new ChromeDriver();
			System.out.println("----- chrome browser launched successfully-----");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		
		//Step 3: login to App
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();		
		
		//Step 4: navigate to organizations
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 5: navigate create Organizations
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Create organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(Orgname+RANDOM);
		
		//Step 7: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 8: logout
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("-----Scenario executed successfully------");
		
	}



	}


