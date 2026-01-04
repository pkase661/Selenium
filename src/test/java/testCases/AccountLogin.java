package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.MyAccountPage;
import testBase.BaseClass;

public class AccountLogin extends BaseClass {
	
	
	@Test
	void verify_login() {
		logger.info("*********** Startign TC02_002_LoginTest ************");
		
		//
		try {
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPD(p.getProperty("pwd"));
		lp.login();
		
		MyAccountPage map= new MyAccountPage(driver);
		boolean targetpage=map.isMyAccountPageExists();
		
		
		Assert.assertEquals(targetpage, true);
		}
		catch(Exception e) {
			Assert.fail();
			
		}
		logger.info("********** Finished TC_0002 LoginTest **********");
		
		
	}
	

}
