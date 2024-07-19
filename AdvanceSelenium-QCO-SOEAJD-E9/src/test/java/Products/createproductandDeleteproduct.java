package Products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import Object_Repository.CreateProductPage;
import Object_Repository.DelProduct;
import Object_Repository.VtigerHomepage;
import Object_Repository.VtigerLoginPage;

public class createproductandDeleteproduct extends BaseClass {
     @Test
	public  void createproductandDeleteproduct() throws Throwable {
		/*File_Utility flib = new File_Utility();
		Webdriver_Utility wlib = new Webdriver_Utility();
		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();
		
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
		String FASSWORD = flib.getkeyandvaluepair("password");
		driver.get(URL);
		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.LogiToVtigerApp(USERNAME, FASSWORD);*/
    	 Webdriver_Utility wlib = new Webdriver_Utility();
 		Excel_Utility elib = new Excel_Utility();
 		Java_Utility jlib = new Java_Utility();
		VtigerHomepage home = new VtigerHomepage(driver);
		home.Productlink();
		CreateProductPage prdpage = new CreateProductPage(driver);
		prdpage.clickonplus();
		
		int rannum = jlib.getRannum();
		
		String PrdData = elib.getexceldata("products", 0, 0)+rannum;
		prdpage.enterProductName(PrdData);
		prdpage.clickOnSaveButtin();
		home.Productlink();
		DelProduct delete = new DelProduct(driver);
		delete.selectPrdCheckBox(driver, PrdData);
		delete.clickOnDeleteButton();
		
		wlib.getalertpopupaccept(driver);
		delete.ValidatPrdName(driver, PrdData);
		Thread.sleep(2000);
		//home.logout(driver);
		

	}

}
