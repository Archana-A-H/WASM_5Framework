package vitiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all generic methods related to web driver actions
 * @author HP
 *
 */

public class WebDriverUtility {
	/**
	 * This method maximizes the window
	 * @param driver
	 */
public void maximizeWindow(WebDriver driver)
{
	driver.manage().window().maximize();
}
/**
 * This method waits for the specified seconds for entire DOM structure to load
 * @param driver
 * @param sec
 */
public void waitForElementsToLoadInDom(WebDriver driver,int sec)
{
	driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
}
/**
 * This method will wait foe particular element to be visible
 * @param driver
 * @param element
 */
public void waitForElementToLoad(WebDriver driver,WebElement element)
{
  WebDriverWait wait=new WebDriverWait(driver,20);
  wait.until(ExpectedConditions.visibilityOf(element));
}
/**
 * This method will wait till the element is clickable
 * @param driver
 * @param element
 */
public void waitForElementToBeClickable(WebDriver driver,WebElement element)
{
 WebDriverWait wait=new WebDriverWait(driver,20);
 wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * This method will wait for the element to perform click operation if element is not interactive it will wait for 1 second 
 * @param element
 * @throws InterruptedException
 */
public void customWaitAndClickOnElement(WebElement element) throws InterruptedException
{
  int count = 0;	
  while(count<10)
  {
  try 
  {
	element.click();
	break;
  }
  catch(Exception e)
  {
	  Thread.sleep(1000);
	  count++;
  }
}
}
/**
 * This method selects the element from the drop down by index
 * @param element
 * @param index
 */
public void handleDropDown(WebElement element,int index)
{
  Select s=new Select(element);	
  s.selectByIndex(index);
}
/**
 * This method selects the element from the drop down by visible text
 * @param element
 * @param text
 */
public void handleDropDown(WebElement element,String text)
{
 Select s=new Select(element);
 s.selectByVisibleText(text);
}
/**
 * This method selects the element from drop down by value
 * @param value
 * @param element
 */
public void handleDropDown(String value,WebElement element) 
{
	Select s=new Select(element);
	s.selectByValue(value);
}
/**
 * This method performs double click over the page
 * @param driver
 */
public void doubleClickOn(WebDriver driver)
{
 	Actions a=new Actions(driver);
 	a.doubleClick().perform();
}
/**
 * This method perform doubleClick on Specified element
 * @param driver
 * @param element
 */
public void doubleClickOn(WebDriver driver,WebElement element)
{
 Actions a=new Actions(driver);	
 a.doubleClick(element);
}
/**
 * This method performs drag and drop action from source element to target element
 * @param driver
 * @param srcele
 * @param target
 */
public void dragAndDrop(WebDriver driver,WebElement srcele,WebElement target)
{
 Actions a=new Actions(driver);
 a.dragAndDrop(srcele, target).perform();
}
/**
 * This method performs mouse hover on specified web element
 * @param driver
 * @param element
 */
public void mouseHover(WebDriver driver,WebElement element)
{
 Actions a=new Actions(driver);
 a.moveToElement(element).perform();
}
/**
 * This method performs mouse hover on offset value
 * @param driver
 * @param x
 * @param y
 */
public void mouseHover(WebDriver driver,int x,int y)
{
 Actions a=new Actions(driver);
 a.moveByOffset(x, y).perform();
}
/**
 * This method performs right click on the web page
 * @param driver
 */
public void rightClickOn(WebDriver driver)
{
 Actions a=new Actions(driver);
 a.contextClick().perform();
}
/**
 * This method performs right click on target element
 * @param driver
 * @param element
 */
public void rightClickOn(WebDriver driver,WebElement element)
{
 Actions a=new Actions(driver);
 a.contextClick(element).perform();
}
/**
 * This method accepts alert pop up
 * @param driver
 */
public void alertAccept(WebDriver driver)
{
 driver.switchTo().alert().accept();	
}
/**
 * This method dismisses alert pop up
 * @param driver
 */
public void alertDismiss(WebDriver driver)
{
 driver.switchTo().alert().dismiss();	
}
public String getAlertText(WebDriver driver)
{
 String txt = driver.switchTo().alert().getText();
 return txt;
}

/**
 * This method switches to window with the specified title
 * @param driver
 * @param partialTitle
 */
public void switchToWin(WebDriver driver,String partialTitle)
{
//Step 1:get all window handles
	
 Set<String> winids = driver.getWindowHandles();
 
 //step 2:iterate through all window ids
 Iterator<String> winit = winids.iterator();
 
 //Step 3:Navigate through all window ids
 while(winit.hasNext())
 {   
	//capture all window ids
	 String winid = winit.next();
	 
	 // switch to the window and capture window title 
	 String currentTitle = driver.switchTo().window(winid).getTitle();
	 //
	 if(currentTitle.contains(partialTitle))
	 {
		 break;
	 }
 }
}
/**
 * This method switches to frame with the specified index
 * @param driver
 * @param index
 */
public void switchToFrame(WebDriver driver,int index)
{
  driver.switchTo().frame(index);	
}
/**
 * This method switches to frame with the specified id/name
 * @param driver
 * @param idorname
 */
public void switchToFrame(WebDriver driver,String idorname)
{
  driver.switchTo().frame(idorname);	
}
/**
 * This method switches to frame with the specified web element
 * @param driver
 * @param element
 */
public void switchToFrame(WebDriver driver,WebElement element)
{
 driver.switchTo().frame(element);	
}
/**
 * This method takes screen shot and returns destination address
 * @param driver
 * @param ssname
 * @return
 * @throws IOException
 */
public String takeScreenShot(WebDriver driver,String ssname) throws IOException
{
 TakesScreenshot ts = (TakesScreenshot)driver;	
 File src = ts.getScreenshotAs(OutputType.FILE);
 String path = ".\\screenShots\\"+ssname+".png";
 File dst = new File(path);
 FileUtils.copyFile(src, dst);
 return dst.getAbsolutePath();//used for reporting in listeners
}
/**
 * This method will perform random scroll
 * @param driver
 */
public void scrollAction(WebDriver driver)
{
 JavascriptExecutor js = (JavascriptExecutor)driver;
 js.executeScript("window.scrollBy(0,600)", "");
}
/**
 * This method will perform scroll on specified element
 * @param driver
 * @param ele
 */
public void scrollAction(WebDriver driver,WebElement ele)
{
 JavascriptExecutor js = (JavascriptExecutor)driver;
 int x = ele.getLocation().getX();
 int y = ele.getLocation().getY();
 
 js.executeScript("window.scrollBy("+x+","+y+")", ele);
}

}