package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerLoginPage {
	//initialization
	public VtigerLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//element declaration
	@FindBy(name = "user_name")
	private WebElement UserTextField;
	
	@FindBy(name = "user_password")
	private WebElement PasswordTextField;
	
	@FindBy(id = "submitButton")
	private WebElement SubmitButton;
	//getter methods
	public WebElement getUserTextField() {
		return UserTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getSubmitButton() {
		return SubmitButton;
	}
	
    /**
     * this method ued to login to application
     */
	
	public void LogiToVtigerApp(String username, String Password)
	{
		UserTextField.sendKeys(username);
		PasswordTextField.sendKeys(Password);
		SubmitButton.click();
		
		
	}
	
}
