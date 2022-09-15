package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.CreateNewOrganization;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class POMpractice {

	public static void main(String[] args) {
		// Launch Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://localhost:8888");

		//Login to app
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		CreateNewOrganization cn=new CreateNewOrganization(driver);
		//Using getter method
		/*WebElement username = lp.getUserNameEdt();
		username.sendKeys("admin");
		lp.getPasswordEdt().sendKeys("admin");
		lp.getLoginBtn().click();*/
		
		//Using Business Library
		lp.loginToApp("admin", "admin");
		
	}

}
