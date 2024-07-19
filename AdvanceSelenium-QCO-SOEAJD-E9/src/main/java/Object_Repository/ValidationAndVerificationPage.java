package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidationAndVerificationPage {
	
	public ValidationAndVerificationPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void orgvalidation(WebDriver driver, String data) 
	{
		
		
	String actdata = driver.findElement(By.id("dtlview_Organization Name")).getText();
	 
	 if(actdata.contains(data))
	 {
		 System.out.println("org data is passed");
	 }
	 else
	 {
		 System.out.println("org data is not passed");
	 }

}
}
