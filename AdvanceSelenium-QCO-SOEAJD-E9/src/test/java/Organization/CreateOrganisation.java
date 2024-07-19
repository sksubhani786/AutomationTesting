package Organization;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import Object_Repository.CreateOrganisationPage;
import Object_Repository.ValidationAndVerificationPage;
import Object_Repository.VtigerHomepage;
import Object_Repository.VtigerLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisation extends BaseClass  {
    @Test//(groups = "adhoctest")
	public  void CreateOrganisation() throws Throwable {
		WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		//WebDriver driver;
		File_Utility flib = new File_Utility();
		Excel_Utility elib = new Excel_Utility();
		/*String BROWSER = flib.getkeyandvaluepair("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}else
			if(BROWSER.equalsIgnoreCase("edge"))
			{
				driver=new EdgeDriver();
			}else
				if(BROWSER.equalsIgnoreCase("firefox"))
				{
					driver= new FirefoxDriver();
				}
				else
				{
					driver= new ChromeDriver();
				}
		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.getwindowmaximize(driver);
		wlib.getimplicitlywait(driver);
		String URL = flib.getkeyandvaluepair("url");
		String USERNAME = flib.getkeyandvaluepair("username");
		String PASSWORD = flib.getkeyandvaluepair("password");
		
		
		
		driver.get(URL);
		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.LogiToVtigerApp(USERNAME, PASSWORD);*/
		
		VtigerHomepage home = new VtigerHomepage(driver);
		home.Organizationlink();
		//driver.findElement(By.linkText("Organizations")).click();
		CreateOrganisationPage organisationdata = new CreateOrganisationPage(driver);
		organisationdata.clickplusimg(driver);
		//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		
		Java_Utility jlib = new Java_Utility();
		int rannum = jlib.getRannum();
        String orgdata = elib.getexceldatausingdataformatter("organisation", 0, 0)+rannum;
		//driver.findElement(By.name("accountname")).sendKeys(orgdata);
		String phnnum = elib.getexceldatausingdataformatter("organisation", 1, 0);
		//driver.findElement(By.id("phone")).sendKeys(phnnum);
		String emaildata = elib.getexceldatausingdataformatter("organisation", 2, 0);
		//driver.findElement(By.id("email1")).sendKeys(emaildata);
		//CreateOrganisationPage organisationdata = new CreateOrganisationPage(driver);
		organisationdata.enterorganisationdata(orgdata, phnnum, emaildata);
		organisationdata.clickonsavebutton(driver);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));read.sleep(1000);
		
		ValidationAndVerificationPage validdata = new ValidationAndVerificationPage(driver);
		validdata.orgvalidation(driver, orgdata);
		//home.logout(driver);
		/* String actdata = driver.findElement(By.id("dtlview_Organization Name")).getText();
		 
		 if(actdata.contains(orgdata))
		 {
			 System.out.println("org data is passed");
		 }
		 else
		 {
			 System.out.println("org data is not passed");
		 }*/
		//home.logout(driver);
		//home.admlink();
		//home.signoutlink();
		//Actions act = new Actions(driver);
		//act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.linkText("Sign Out")).click();
		
		
		
		
	}

}
