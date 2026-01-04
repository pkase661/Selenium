package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage  {
	
//	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement xemail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement xpwd;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement xLogin;
	
	
	
	public void setEmail(String email) {
		xemail.sendKeys(email);
	}
	
	public void setPD(String pd) {
		xpwd.sendKeys(pd);
	}
	
	public void login() {
		xLogin.click();
	}
	
	
	

}
