package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement plussign;
	
	@FindBy(name = "productname")
	private WebElement Prdname;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;

	public WebElement getPlussign() {
		return plussign;
	}

	public WebElement getPrdname() {
		return Prdname;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	public void clickonplus()
	{
		plussign.click();
	}
		
	public void enterProductName(String productname)
	{
		Prdname.sendKeys(productname);
	}
	public void clickOnSaveButtin()
	{
		SaveButton.click();
	}

}
