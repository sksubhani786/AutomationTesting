package Products;

import java.time.Duration;

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
import Generic_Utility.Webdriver_Utility;
import Object_Repository.CreateProductPage;
import Object_Repository.VtigerHomepage;
import Object_Repository.VtigerLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
//@Listeners(Generic_Utility.ExtentReportImp.class)
public class CreateProducts extends BaseClass{
@Test//(groups = {"smoketest","adhoctest"})
	public  void CreateProducts() throws Throwable {
		WebDriverManager.chromedriver().setup();
		
		File_Utility flib = new File_Utility();
		Webdriver_Utility wlib = new Webdriver_Utility();
		
		Excel_Utility elib = new Excel_Utility();
		String prddata = elib.getexceldatausingdataformatter("products", 0, 0);
		System.out.println(prddata);
		VtigerHomepage home = new VtigerHomepage(driver);
		home.Productlink();
		CreateProductPage prdpage = new CreateProductPage(driver);
		prdpage.clickonplus();
		prdpage.enterProductName(prddata);
		prdpage.clickOnSaveButtin();
		//Assert.assertEquals(false, true);
		String actdata = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		System.out.println(actdata);
		Thread.sleep(1000);
		//Assert.assertEquals(actdata, prddata);
		//home.admlink();
		//home.logout(driver);
		//SoftAssert soft = new SoftAssert();
		//soft.assertAll();



	}

}
