package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchingDataFromProperty {

	public static void main(String[] args) throws IOException {
		
		
		//1)create a FileInputStream obj
		FileInputStream fis = new FileInputStream("./src/test/resources/prop.properties");
        //2)create a property File Obj
		Properties p = new Properties();
		//3)Load File
		p.load(fis);
		//4)Fetch The Data
		System.out.println(p.getProperty("url"));
		System.out.println(p.getProperty("email"));
		System.out.println(p.getProperty("password"));
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url"));
		driver.findElement(By.id("Email")).sendKeys(p.getProperty("email"));
		driver.findElement(By.name("Password")).sendKeys(p.getProperty("password"));
		driver.findElement(By.name("RememberMe")).click();
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
	}

}
