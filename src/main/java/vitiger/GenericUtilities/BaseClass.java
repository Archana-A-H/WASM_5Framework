package vitiger.GenericUtilities;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
/**
 * This class contains basic configuration annotation for common functionalities
 * like Database connection,launching browser etc.
 * @author HP
 *
 */
public class BaseClass 
{
 public DatabaseUtilities db=new DatabaseUtilities();
 public ExcelFileUtility eUtil=new ExcelFileUtility();
 public PropertyFileUtility pUtil=new PropertyFileUtility();
 public WebDriverUtility wUtil=new WebDriverUtility();
 public JavaUtility jUtil=new JavaUtility();

 public WebDriver driver=null;
 public static WebDriver sdriver=null;
 
 @BeforeSuite(groups={"SmokeSuite","RegressionSuite"})
 public void bsConfig() throws SQLException
 {
	 //db.connectToDB();
	 Reporter.log("DATABASE CONNECTION SUCCESSFULL", true);
 }
 
 //@Parameters("BROWSER")
  //@BeforeTest
 @BeforeClass(groups={"SmokeSuite","RegressionSuite"})
 
 public void bcConfig(/*String BROWSER*/) throws IOException
 {
	 String BROWSER = pUtil.readFromPropertyFile("browser");
	 String URL = pUtil.readFromPropertyFile("url");
	 
	 if(BROWSER.equalsIgnoreCase("chrome"))
	 {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 Reporter.log("CHROME"+ BROWSER+"LAUNCHED", true);
	 }
	 else if(BROWSER.equalsIgnoreCase("firefox"))
	 {
		 WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
		 Reporter.log("FIREFOX"+ BROWSER+" LAUNCHED", true);
	 }
	 else
	 {
		 Reporter.log("Invalid Browser", true);
	 }
	 sdriver=driver;
	 wUtil.maximizeWindow(driver);
	 wUtil.waitForElementsToLoadInDom(driver, 20);
	 driver.get(URL);
 }
 @BeforeMethod
 public void bmConfig() throws IOException
 {
	 String USERNAME = pUtil.readFromPropertyFile("username");
	 String PASSWORD = pUtil.readFromPropertyFile("password");
	 LoginPage lp=new LoginPage(driver);
	 lp.loginToApp(USERNAME, PASSWORD);
	 Reporter.log("LOGIN SUCCESSFUL", true);
 }
 @AfterMethod
 public void amConfig()
 {
	 HomePage hp=new HomePage(driver);
	 hp.signOutApp(driver);
	 Reporter.log("SIGN OUT SUCCESSFUL", true);
 }
 //@AfterTest
 @AfterClass
 public void acConfig()
 {
	driver.close();
	Reporter.log("DRIVER CLOSED SUCCESSFULLY", true);
 }
 @AfterSuite
 public void asConfig() throws SQLException
 {
	 //db.closeDB();
	 Reporter.log("DATABASE CLOSED SUCCESSFULLY", true);
 }
 
}
