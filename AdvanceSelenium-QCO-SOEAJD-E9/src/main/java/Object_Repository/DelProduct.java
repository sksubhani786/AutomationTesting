package Object_Repository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DelProduct {

	 public DelProduct(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }
	 @FindBy(xpath = "//input[@value='Delete']")
	 private WebElement deleteprd;
	 
	 public void selectPrdCheckBox(WebDriver driver, String prdname)
	 {
		 driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+prdname+"']/../preceding-sibling::td/input[@type='checkbox']")).click();
	 }
	 
	 public void clickOnDeleteButton()
	 {
		 deleteprd.click();
	 }
	 public void ValidatPrdName(WebDriver driver, String prddata)
	 {
		 List<WebElement> allprds = driver.findElements(By.xpath("(//table[@class='lvt small']//tbody//tr//td[3])[position()>1]"));
			
			boolean flag=false;
			
			for (WebElement prdname : allprds)
			{
				String actname = prdname.getText();
				if (actname.contains(prddata)) 
				{
					flag=true;
							break;
				

				}
			}
			
			if (flag) 
			{
				System.out.println("product data is deleted");
			} else
			
			{

				System.out.println("product data is not deleted");
			}
	 }
}
