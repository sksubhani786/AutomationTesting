package Generic_Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import Object_Repository.VtigerHomepage;
import Object_Repository.VtigerLoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver sdriver;
	Webdriver_Utility wlib = new Webdriver_Utility();
	File_Utility flib = new File_Utility();
	Excel_Utility elib = new Excel_Utility();
	@BeforeSuite(groups = {"smoketest","adhoctest"})
	public void BS()
	{
		System.out.println("database is created");
	}
	@BeforeTest(groups = {"smoketest","adhoctest"})
	public void BT()
	{
		System.out.println("parallel excution is started");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smoketest","adhoctest"})
	public void BC( ) throws Throwable
	{
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
		sdriver = driver;
		System.out.println("browser lanched");
	}
	
	@BeforeMethod(groups = {"smoketest","adhoctest"})
	public void BM() throws Throwable
	{
		wlib.getwindowmaximize(driver);
		wlib.getimplicitlywait(driver);
		
		String URL = flib.getkeyandvaluepair("url");
		String USERNAME = flib.getkeyandvaluepair("username");
		String PASSWORD = flib.getkeyandvaluepair("password");
		driver.get(URL);
		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.LogiToVtigerApp(USERNAME, PASSWORD);
		System.out.println("login to application");
	}
	@AfterMethod(groups = {"smoketest","adhoctest"})
	public void AM()
	{
		System.out.println("logout to application");
	}
    @AfterClass(groups = {"smoketest","adhoctest"})
	public void AC()
	{
    	VtigerHomepage home = new VtigerHomepage(driver);
    	home.logout(driver);
		System.out.println("logout to application");
	}
	@AfterTest(groups = {"smoketest","adhoctest"})
	public void AT()
	{
		System.out.println("parallel excution is done");
	}
	@AfterSuite(groups = {"smoketest","adhoctest"})
	public void AS() throws Throwable
	{
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_details","root","root");
		conn.close();
		System.out.println("database is closed");
	}
}
