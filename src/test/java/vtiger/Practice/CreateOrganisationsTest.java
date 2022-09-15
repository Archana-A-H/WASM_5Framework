package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class CreateOrganisationsTest {

	public static void main(String[] args) {
		// Step 1:Launch the browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		//Step 2:Login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3:Navigate to Organizations link
		driver.findElement(By.linkText("Organizations")).click();
		
		//step 4:Click on create organization look up image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Step 5:Enter Mandatory Fields
		driver.findElement(By.name("accountname")).sendKeys("Infosys");
		
		//step 6:Save
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		Select s = new Select(driver.findElement(By.name("industry"))); 
		 s.selectByVisibleText("Healthcare");
		
		 //Step 7:Logout
		 WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 Actions a=new Actions(driver);
		 a.moveToElement(ele);
		 a.perform();
		 driver.findElement(By.linkText("Sign Out")).click();
		 
		
		driver.close();
		System.out.println("Organization Created");
		

	}


}
