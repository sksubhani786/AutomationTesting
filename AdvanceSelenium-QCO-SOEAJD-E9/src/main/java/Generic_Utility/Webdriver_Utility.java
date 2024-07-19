package Generic_Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Webdriver_Utility {
	/**This method is used to maximize the window
	 * @author Dell
	 * @param driver
	 */
	public void getwindowmaximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**This method used to wait for element get loaded
	 * @author Dell
	 * @param driver
	 */
public void getimplicitlywait(WebDriver driver)

{
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
/**This method is used to get window handling
 * 
 * @param driver
 * @param partialvalue
 */
public void getwindowhandling(WebDriver driver, String partialvalue )
{
	Set<String> win = driver.getWindowHandles();
	Iterator<String> it = win.iterator();
	while(it.hasNext())
	
	{
		String wins = it.next();
		driver.switchTo().window(wins);
		String curtitle = driver.getTitle();
		if(curtitle.contains(partialvalue));
		
		{
		
			break;            
		}}
}
/**
 * This methos is used to accept the popup
 * @param driver
 */
public void getalertpopupaccept(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
/**
 * This method is used to dismiss the popup
 * @param driver
 */
public void getalertpopupdismiss(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
public void movetoelement(WebDriver driver, WebElement ele)
{
	Actions act = new Actions(driver);
	act.moveToElement(ele).perform();
	
}
public static String takescreenShot(WebDriver driver, String screenshotname) throws Throwable 
{
	TakesScreenshot takesScreenshot = (TakesScreenshot) driver; 
	File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
	File dest = new File("./screenshot/"+screenshotname+".png");
	FileUtils.copyFile(src, dest);
	return dest.getAbsolutePath();
	
}
}
