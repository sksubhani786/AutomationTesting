package Campaign;



import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import Object_Repository.CampWithPrdWindowSwitching;
import Object_Repository.CreateCampaignPage;
import Object_Repository.CreateProductPage;
import Object_Repository.VtigerHomepage;
import Object_Repository.VtigerLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProduct {

	//public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		Java_Utility jlib = new Java_Utility();
		File_Utility flib = new File_Utility();
		Excel_Utility elib = new Excel_Utility();
		Webdriver_Utility wlib = new Webdriver_Utility();
		WebDriver driver;
		String BROWSER = flib.getkeyandvaluepair("browser");
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
		wlib.getwindowmaximize(driver);
		wlib.getimplicitlywait(driver);
		
		String URL = flib.getkeyandvaluepair("url");
		String USERNAME = flib.getkeyandvaluepair("username");
		String PASSWORD = flib.getkeyandvaluepair("password");
		driver.get(URL);
		VtigerLoginPage LOGIN = new VtigerLoginPage(driver);
		LOGIN.LogiToVtigerApp(USERNAME, PASSWORD);
		VtigerHomepage home = new VtigerHomepage(driver);
		home.Productlink();
		CreateProductPage PrdPage = new CreateProductPage(driver);
		PrdPage.clickonplus();
		
		int rannum = jlib.getRannum();
		
		String prddata = elib.getexceldata("products", 0, 0)+rannum;
		PrdPage.enterProductName(prddata);
		PrdPage.clickOnSaveButtin();
		home.morelink();
	    home.Campaignlink();
	    CreateCampaignPage CampPage = new CreateCampaignPage(driver);
	    CampPage.clickonplussign();
	    String CampData = elib.getexceldata("campaings", 0, 0)+rannum;
	    CampPage.entercompname(prddata);
	    CampWithPrdWindowSwitching Switching = new CampWithPrdWindowSwitching(driver);
	    Switching.clickOnPrdPlusSign();
	    wlib.getwindowhandling(driver, "Products&action");
	    Switching.enterPrdName(prddata);
	    Switching.searchPrdName();
	    Switching.prdDynamicElement(driver, prddata);
	    wlib.getwindowhandling(driver, "Campaigns&action");
	    CampPage.ClickOnSaveButton();
	    Thread.sleep(2000);
		home.logout(driver);
		/*Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[text()='More']"))).perform();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		
		
		
		
		 String cmpdata = elib.getexceldata("campaings", 0, 0)+rannum;
		//driver.findElement(By.name("campaignname")).sendKeys(cmpdata);
		//driver.findElement(By.xpath("//img[@title='Select']")).click();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//wlib.getwindowhandling(driver, prddata);
		Set<String> win = driver.getWindowHandles();
		Iterator<String> it = win.iterator();
		while(it.hasNext())
		
		{
			String wins = it.next();
			driver.switchTo().window(wins);
			String curtitle = driver.getTitle();
			if(curtitle.contains("Products&action"))
			
			{
			
				break;            
			}
			}
		
		
		driver.findElement(By.id("search_txt")).sendKeys(prddata);
		driver.findElement(By.xpath("//input[@type='button']")).click();
		
		
*/
		}}

	

