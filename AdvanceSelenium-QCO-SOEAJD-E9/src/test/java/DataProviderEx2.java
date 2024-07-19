
import java.time.Duration;
import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderEx2 {
@Test(dataProvider ="readdata" )
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
		driver.findElement(By.name("accountname")).sendKeys(orgnme);
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
	  Object[][] objArry = new Object[3][3];
	  Random ran = new Random();
	  int ranNum = ran.nextInt(1000);
	  
	 objArry[0][0]="AAA"+ranNum;
	  objArry[0][1]="8521479630";
	  objArry[0][2]="abc@gmail.com";
	  
	  objArry[1][0]="BBB"+ranNum;
	  objArry[1][1]="8521479630";
	  objArry[1][2]="pqr@gmail.com";
	  
	  objArry[2][0]="CCC"+ranNum;
	  objArry[2][1]="8521479630";
	  objArry[2][2]="xyz@gmail.com";
	
	return objArry;






   }




}
