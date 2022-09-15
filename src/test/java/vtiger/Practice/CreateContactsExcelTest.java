package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateContactsExcelTest {

	@Test
	public void  CreateContactTest() throws IOException {
		WebDriver driver;
		
		//Step1:Read necessary data
		
		//--Property File->Common data--
		FileInputStream fp=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties p=new Properties();
		p.load(fp);
		String Browser = p.getProperty("browser");
		String Url = p.getProperty("url");
		String UN = p.getProperty("username");
		String Pwd = p.getProperty("password");
		
		//--Excel Sheet->Test Data--
		FileInputStream fe=new FileInputStream(".\\\\src\\\\test\\\\resources\\\\testData.xlsx");
		Workbook wb=WorkbookFactory.create(fe);
		org.apache.poi.ss.usermodel.Sheet s=wb.getSheet("Contacts");
		Row row=s.getRow(1);
		Cell c=row.getCell(2);
		String Lastname = c.getStringCellValue();
		
		//step2:Launch the Browser
		if(Browser.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
			System.out.println("Chrome Browser started");
		}
		else if(Browser.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
			System.out.println("Firefox Browser Started");
		}
		else
		{
			driver=new ChromeDriver();
			System.out.println("chrome Browser started");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Url);
		
		//Step 3:Login to application
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(Pwd);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 4:Navigate to Contacts Link
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 5:Navigate to create Contacts image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//Step 6:Create Contact With mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(Lastname);
		
		//Step 7:Save Contact
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]'][1]")).click();
		
		//Step 8:Log out
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    Actions a=new Actions(driver);
	    a.moveToElement(ele);
	    a.perform();
	    driver.findElement(By.linkText("Sign Out")).click();
	}
}

	    

	


