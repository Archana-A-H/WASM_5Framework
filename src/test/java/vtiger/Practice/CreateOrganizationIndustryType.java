package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationIndustryType {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("Wipro");
		System.out.println("Wipro Organization created");
		Select s=new Select(driver.findElement(By.name("industry")));
		s.selectByVisibleText("Electronics");
		System.out.println("Electronics Industry Selected");
		Select s1=new Select(driver.findElement(By.name("accounttype")));
		s1.selectByVisibleText("Investor");
		System.out.println("Type Investor Selected");
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]"));
		driver.close();

	}

}
