package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AccountRegisterPage;
import PageObject.HomePage;
import testBase.BaseClass;

public class AccountRegistrationPage extends BaseClass{
	@Test(groups= {"sanity", "master"})
	public void verify_account_reg() {
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Click on MyAccount Link...");
		
		
		hp.clickRegister();
		logger.info("Clicked on register Link..");
		
		
		AccountRegisterPage regpage= new AccountRegisterPage(driver);
		logger.info("Providing Customer Details..");
		regpage.setFirstName(genrateAlphabate());
		regpage.setLirstName(genrateAlphabate());
		regpage.setEmail(genrateAlphabate()+"@gmail.com");
		regpage.setPhoneNumber(genrateNumeric());
		
		String pw = genrateAlphaNumaric();
		regpage.setpw(pw);
		regpage.confirmPw(pw);
		regpage.clickRedioB();
		
		regpage.clickCheckBox();
		regpage.clickContinue();
		
		logger.info("Validating expected message...");
		String confmsg=regpage.getConfirmationMsg();
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!!!");
		if(confmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test failed...");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
			
		}
		
		}
		catch(Exception e) {
			
			Assert.fail();
		}
		
		logger.info("****** Finished TC01_AccountRegistrationTest******");
		
		
	}
	
	

}
