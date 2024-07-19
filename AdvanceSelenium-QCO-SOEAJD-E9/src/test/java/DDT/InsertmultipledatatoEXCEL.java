package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InsertmultipledatatoEXCEL {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/exceldata.xlsx");
		
		Workbook wb= WorkbookFactory.create(fis);
		
		 Sheet sh = wb.getSheet("sheet5");
		 
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://demowebshop.tricentis.com");
		 List<WebElement> links = driver.findElements(By.xpath("//a"));
		 for(int i=0; i<links.size();i++) {
			 Cell cell = wb.getSheet("sheet5").createRow(i).createCell(0);
			 cell.setCellValue(links.get(i).getAttribute("href"));
		 }
		FileOutputStream fos = new FileOutputStream("./src/test/resources/exceldata.xlsx");
		
		wb.write(fos);
		wb.close();
		
		System.out.println("data created");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
