package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage{
	
	public AccountRegisterPage(WebDriver driver) {
		super(driver);
	}
	
	//Locater
	//------------------------------------------
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement fname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement Lname; 
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement phoneno;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement pwd;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement c_pwd;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	WebElement redio_click;
	
	@FindBy(xpath="//input[@name=\"agree\"]")
	WebElement check_box;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement click_continue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement c_massg;
	
	
	
	//Methods
	
	public void setFirstName(String f_name) {
		fname.sendKeys(f_name);
	 }
	
	public void setLirstName(String l_name) {
		Lname.sendKeys(l_name);	 	
	}
	
	public void setEmail(String e_mail) {
		email.sendKeys(e_mail);	 	
	}

	public void setPhoneNumber(String p_number) {
		phoneno.sendKeys(p_number);	 	
	}
	
	public void setpw(String PW) {
		pwd.sendKeys(PW);
	}
	
	public void confirmPw(String C_PW) {
		c_pwd.sendKeys(C_PW);	
	}
	
	public void clickRedioB() {
		redio_click.click();
	}
	public void clickCheckBox() {
		check_box.click();	
	}
	
	public void clickContinue() {
		click_continue.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return (c_massg.getText());
		}catch(Exception e) {
			return (e.getMessage());
		}
		
	}
	
}
