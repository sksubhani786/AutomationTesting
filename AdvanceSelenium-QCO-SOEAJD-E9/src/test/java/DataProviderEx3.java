

	import java.time.Duration;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

	public class DataProviderEx3 {
	@Test(dataProvider ="readdata")
		public void createorganization(String orgnme, String phnNum, String email) throws Throwable
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("http://localhost:8888/");
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();

			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			Java_Utility jlib = new Java_Utility();
			int ranNum = jlib.getRannum();
			driver.findElement(By.name("accountname")).sendKeys(orgnme+ranNum);
			driver.findElement(By.id("phone")).sendKeys(phnNum);
			driver.findElement(By.id("email1")).sendKeys(email);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.linkText("Sign Out")).click();
			Thread.sleep(1000);
			driver.quit();
		}
	    @DataProvider
	   public Object[][] readdata() throws Throwable
	   {
	    	Excel_Utility elib = new Excel_Utility();
	    	Object[][] values = elib.readdatausingdataprovider("DataProvider");
	    	return values;
	    	}
		
	   
	   }
	
	