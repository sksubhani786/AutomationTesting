package Campaign;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import Object_Repository.CreateCampaignPage;
import Object_Repository.CreateProductPage;
import Object_Repository.VtigerHomepage;
import Object_Repository.VtigerLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
//@Listeners(Generic_Utility.ExtentReportImp.class)
public class CreateCampaign extends BaseClass {
//@Test(groups = "smoketest")
	@Test
	public   void createCampaign() throws Throwable {
		WebDriverManager.chromedriver().setup();
		File_Utility flib = new File_Utility();
		
		Webdriver_Utility wlib = new Webdriver_Utility();
		
		VtigerHomepage home = new VtigerHomepage(driver);
		home.morelink();
		home.Campaignlink();
		//Assert.assertEquals(false, true);
		Excel_Utility elib = new Excel_Utility();
		String campdata = elib.getexceldatausingdataformatter("campaings", 0, 0);
		System.out.println(campdata);
		
		CreateCampaignPage camppage = new CreateCampaignPage(driver);
		camppage.clickonplussign();
		camppage.entercompname(campdata);
		camppage.ClickOnSaveButton();
		String actdata = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		System.out.println(actdata);
		//camppage.ClickOnSaveButton();
		Thread.sleep(1000);
		home.admlink();
		//Assert.assertEquals(actdata, campdata);
		//SoftAssert soft = new SoftAssert();
		//soft.assertEquals(actdata, campdata);
		//soft.assertAll();
		//home.logout(driver);


	}


}
