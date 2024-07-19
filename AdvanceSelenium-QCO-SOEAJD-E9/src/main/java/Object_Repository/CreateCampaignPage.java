package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	
	public CreateCampaignPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement plussign;
	
	@FindBy(name = "campaignname")
	private WebElement compname;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getPlussign() {
		return plussign;
	}

	public WebElement getCompname() {
		return compname;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void clickonplussign()
	{
		plussign.click();
	}
	public void entercompname(String campaignName)
	{
		compname.sendKeys(campaignName);
	}
	
	public void ClickOnSaveButton()
	{
		saveButton.click();
	}

}
